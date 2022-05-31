package DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import models.Produto;

/**
 *
 * @author Alexandre Machado
 * @see controller.ProdutosController
 */
public class ProdutosDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
    private static final String LOGIN = "root"; //nome do usuário do banco
    private static final String SENHA = ""; //senha de acesso ao banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/nebulatech?useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;
    private static ResultSet rs;
    private static Statement instrucaoSQL;

    /**
     *
     * @ArrayList<Produto>
     */
    public static ArrayList<Produto> consultarProdutos() {
        ArrayList<Produto> listaRetorno = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM produto;");
            if (rs != null) {
                while (rs.next()) {
                    Produto c = new Produto();
                    c.setCodigo(rs.getInt("cd_produto"));
                    c.setNome(rs.getString("nm_produto"));
                    c.setDesc(rs.getString("descricao"));
                    c.setPreco(rs.getFloat("preco"));
                    c.setQuantidade(rs.getInt("estoque"));
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
    } //fim do método consultarProdutos

    /**
     *
     * @param nome objeto do tipo String
     * @param desc objeto do tipo String
     * @param quant objeto do tipo Float
     * @param preco objeto do tipo Integer
     *
     */
    public static void adicionarProdutos(String nome, String desc, float preco, int quant) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("insert into produto (nm_produto,descricao,preco,estoque) values ('" + nome + "', '" + desc + "', " + preco + ", " + quant + ")");
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
    }//fim do método adicionarProdutos

    /**
     *
     * @param id Objeto do tipo Ineteger
     */
    public static void excluirProdutos(int id) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("DELETE FROM produto where cd_produto = " + id + ";");
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
    }//fim do método excluirProdutos

    /**
     *
     * @param id objeto do tipo Integer
     * @param nome objeto do tipo String
     * @param desc objeto do tipo String
     * @param quant objeto do tipo Float
     * @param preco objeto do tipo Integer
     *
     */
    public static void alterarProdutos(int id, String nome, String desc, float preco, int quant) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("update produto set nm_produto = '" + nome + "',descricao = '" + desc + "',preco = " + preco + ",estoque = " + quant + " where cd_produto =" + id + ";");
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
    }//fim do método alterarProdutos

    /**
     *
     * @param filtro objeto do tipo String
     * @return ArrayList<Produto>
     *
     */
    public static ArrayList<Produto> filtrarProdutos(String filtro) {
        ArrayList<Produto> listaRetorno = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            int cont = 0;
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM produto where nm_produto = '" + filtro + "';");
            if (rs != null) {
                while (rs.next()) {
                    Produto c = new Produto();
                    c.setCodigo(rs.getInt("cd_produto"));
                    c.setNome(rs.getString("nm_produto"));
                    c.setDesc(rs.getString("descricao"));
                    c.setPreco(rs.getFloat("preco"));
                    c.setQuantidade(rs.getInt("estoque"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }
            rs = instrucaoSQL.executeQuery("SELECT * FROM produto where cd_produto = " + filtro + ";");
            if (rs != null) {
                while (rs.next()) {
                    Produto c = new Produto();
                    c.setCodigo(rs.getInt("cd_produto"));
                    c.setNome(rs.getString("nm_produto"));
                    c.setDesc(rs.getString("descricao"));
                    c.setPreco(rs.getFloat("preco"));
                    c.setQuantidade(rs.getInt("estoque"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }
            rs = instrucaoSQL.executeQuery("SELECT * FROM produto where nm_produto like '%" + filtro + "';");
            if (rs != null) {
                while (rs.next()) {
                    Produto c = new Produto();
                    c.setCodigo(rs.getInt("cd_produto"));
                    c.setNome(rs.getString("nm_produto"));
                    c.setDesc(rs.getString("descricao"));
                    c.setPreco(rs.getFloat("preco"));
                    c.setQuantidade(rs.getInt("estoque"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            }
            rs = instrucaoSQL.executeQuery("SELECT * FROM produto where nm_produto like '" + filtro + "%';");
            if (rs != null) {
                while (rs.next()) {
                    Produto c = new Produto();
                    c.setCodigo(rs.getInt("cd_produto"));
                    c.setNome(rs.getString("nm_produto"));
                    c.setDesc(rs.getString("descricao"));
                    c.setPreco(rs.getFloat("preco"));
                    c.setQuantidade(rs.getInt("estoque"));
                    listaRetorno.add(c);
                    cont++;
                }
                if (cont >= 1) {
                    return listaRetorno;
                }
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            listaRetorno = null;
        } catch (ClassNotFoundException ex) {

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
    } //fim do método filtrarProdutos

    /**
     *
     * @param id objeto do tipo Integer
     * @param quant objeto do tipo Integer
     *
     */
    public static void setEstoque(int id, int quant) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("update produto set estoque = " + quant + " where cd_produto =" + id + ";");
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
    }//fim do método alterarProdutos
} // fim da classe ProdutosDAO
