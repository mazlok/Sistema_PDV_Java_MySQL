package DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import models.Cliente;

/**
 *
 * @author Alexandre Machado
 * @see controller.ClientesController
 */
public class ClientesDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
    private static final String LOGIN = "root"; //nome do usuário do banco
    private static final String SENHA = ""; //senha de acesso ao banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/nebulatech?useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;
    private static ResultSet rs;
    private static Statement instrucaoSQL;

    /**
     *
     *
     * @return ArrayList<Cliente>
     */
    public static ArrayList<Cliente> consultarClientes() {
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente;");
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("cd_cliente"));
                    c.setCpf(rs.getString("cpf"));
                    c.setDataNasc(rs.getString("dataNasc"));
                    c.setEmail(rs.getString("email"));
                    c.setEndereço(rs.getString("endereco"));
                    c.setEstadoCivil(rs.getString("estadoCivil"));
                    c.setNome(rs.getString("nm_cliente"));
                    c.setSexo(rs.getString("genero"));
                    c.setTelefone(rs.getString("telefone"));
                    listaRetorno.add(c);
                }
            } else {
                throw new SQLException();
            }
        } catch (SQLException | ClassNotFoundException e) {
            listaRetorno = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
        return listaRetorno;
    } //fim do método consultarClientes

    /**
     *
     * @param cpf objeto do tipo String
     * @param dataNasc objeto do tipo String
     * @param email objeto do tipo String
     * @param endereco objeto do tipo String
     * @param estadoCivil objeto do tipo String
     * @param nome objeto do tipo String
     * @param sexo objeto do tipo String
     * @param telefone objeto do tipo String
     *
     */
    public static void adicionarClientes(String cpf, String dataNasc, String email, String endereco, String estadoCivil, String nome, String sexo, String telefone) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            ArrayList<Cliente> checkList = filtrarClientes(cpf);
            int linhas = 0;
            if (checkList.isEmpty()) {
                linhas = instrucaoSQL.executeUpdate("insert into cliente (nm_cliente, genero, email, endereco, dataNasc, cpf, telefone, estadoCivil) values ('" + nome + "', '" + sexo + "', '" + email + "', '" + endereco + "', " + dataNasc + ", '" + cpf + "','" + telefone + "', '" + estadoCivil + "');");
            }
        } catch (SQLException | ClassNotFoundException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
    }//fim do método adicionarClientes

    /**
     *
     * @param id objeto do tipo Integer
     *
     */
    public static void excluirClientes(int id) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("DELETE FROM cliente where cd_cliente = " + id + ";");
        } catch (SQLException | ClassNotFoundException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
    }//fim do método excluirClientes

    /**
     *
     * @param id objeto do tipo Integer
     * @param cpf objeto do tipo String
     * @param dataNasc objeto do tipo String
     * @param email objeto do tipo String
     * @param endereco objeto do tipo String
     * @param estadoCivil objeto do tipo String
     * @param nome objeto do tipo String
     * @param sexo objeto do tipo String
     * @param telefone objeto do tipo String
     *
     */
    public static void alterarClientes(int id, String cpf, String dataNasc, String email, String endereco, String estadoCivil, String nome, String sexo, String telefone) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("update cliente set nm_cliente = '" + nome + "',genero  = '" + sexo + "',email = '" + email + "',endereco = '" + endereco + "', estadoCivil = '" + estadoCivil + "',  dataNasc = " + dataNasc + ", cpf = '" + cpf + "', telefone = '" + telefone + "' where cd_cliente = " + id + ";");
        } catch (SQLException | ClassNotFoundException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
    }//fim do método alterarClientes

    /**
     *
     * @param filtro objeto do tipo String
     * @return ArrayList<Cliente> 
     */
    public static ArrayList<Cliente> filtrarClientes(String filtro) {
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        int cont = 0;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where nm_cliente = '" + filtro + "';");
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("cd_cliente"));
                    c.setCpf(rs.getString("cpf"));
                    c.setDataNasc(rs.getString("dataNasc"));
                    c.setEmail(rs.getString("email"));
                    c.setEndereço(rs.getString("endereco"));
                    c.setEstadoCivil(rs.getString("estadoCivil"));
                    c.setNome(rs.getString("nm_cliente"));
                    c.setSexo(rs.getString("genero"));
                    c.setTelefone(rs.getString("telefone"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where cpf = '" + filtro + "';");
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("cd_cliente"));
                    c.setCpf(rs.getString("cpf"));
                    c.setDataNasc(rs.getString("dataNasc"));
                    c.setEmail(rs.getString("email"));
                    c.setEndereço(rs.getString("endereco"));
                    c.setEstadoCivil(rs.getString("estadoCivil"));
                    c.setNome(rs.getString("nm_cliente"));
                    c.setSexo(rs.getString("genero"));
                    c.setTelefone(rs.getString("telefone"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where cpf like '%" + filtro + "';");
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("cd_cliente"));
                    c.setCpf(rs.getString("cpf"));
                    c.setDataNasc(rs.getString("dataNasc"));
                    c.setEmail(rs.getString("email"));
                    c.setEndereço(rs.getString("endereco"));
                    c.setEstadoCivil(rs.getString("estadoCivil"));
                    c.setNome(rs.getString("nm_cliente"));
                    c.setSexo(rs.getString("genero"));
                    c.setTelefone(rs.getString("telefone"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where cpf like '" + filtro + "%';");
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("cd_cliente"));
                    c.setCpf(rs.getString("cpf"));
                    c.setDataNasc(rs.getString("dataNasc"));
                    c.setEmail(rs.getString("email"));
                    c.setEndereço(rs.getString("endereco"));
                    c.setEstadoCivil(rs.getString("estadoCivil"));
                    c.setNome(rs.getString("nm_cliente"));
                    c.setSexo(rs.getString("genero"));
                    c.setTelefone(rs.getString("telefone"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }

            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where nm_cliente like '" + filtro + "%';");
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("cd_cliente"));
                    c.setCpf(rs.getString("cpf"));
                    c.setDataNasc(rs.getString("dataNasc"));
                    c.setEmail(rs.getString("email"));
                    c.setEndereço(rs.getString("endereco"));
                    c.setEstadoCivil(rs.getString("estadoCivil"));
                    c.setNome(rs.getString("nm_cliente"));
                    c.setSexo(rs.getString("genero"));
                    c.setTelefone(rs.getString("telefone"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where nm_cliente like '%" + filtro + "';");
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("cd_cliente"));
                    c.setCpf(rs.getString("cpf"));
                    c.setDataNasc(rs.getString("dataNasc"));
                    c.setEmail(rs.getString("email"));
                    c.setEndereço(rs.getString("endereco"));
                    c.setEstadoCivil(rs.getString("estadoCivil"));
                    c.setNome(rs.getString("nm_cliente"));
                    c.setSexo(rs.getString("genero"));
                    c.setTelefone(rs.getString("telefone"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
        return listaRetorno;
    }//fim do método alterarClientes
} // fim da classe ClienteDAO
