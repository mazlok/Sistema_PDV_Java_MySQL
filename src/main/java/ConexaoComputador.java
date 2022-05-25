/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ramon.nbpinheiro
 */
public class ConexaoComputador {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
    private static final String LOGIN = "root"; //nome do usuário do banco
    private static final String SENHA = ""; //senha de acesso ao banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/nebulatech?useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;
    private static ResultSet rs;
    private static Statement instrucaoSQL;

    public ConexaoComputador() {

    }

    public static ArrayList<Produto> consultarProdutos() {
        ArrayList<Produto> listaRetorno = new ArrayList<>();
        try {
//Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM produtos;");
            if (rs != null) {
                while (rs.next()) {
                    Produto c = new Produto();
                    c.setCodigo(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setDesc(rs.getString("descProd"));
                    c.setPreco(rs.getFloat("preco"));
                    c.setQuantidade(rs.getInt("quantidade"));
                    listaRetorno.add(c);
                }
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            listaRetorno = null;
        } catch (ClassNotFoundException ex) {

            listaRetorno = null;
        } finally {
//Libero os recursos usados
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

    public static void adicionarProdutos(String nome, String desc, float preco, int quant) {
        try {
            System.out.println("entrou no adicionar");
//Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("insert into produtos (nome,descProd,preco,quantidade) values ('"+nome+"', '"+desc+"', "+preco+", "+quant+")");
            System.out.println(linhas);
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
        } finally {
//Libero os recursos usados
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
    }
        public static void excluirProdutos(int id) {
        try {
            System.out.println("entrou no excluir");
//Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("DELETE FROM produtos where id = " + id + ";");
            System.out.println(linhas);
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
        } finally {
//Libero os recursos usados
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
    }
        public static void alterarProdutos(int id, String nome, String desc, float preco, int quant) {
        try {
            System.out.println("entrou no adicionar");
//Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("update produtos set nome = '"+nome+"',descProd = '"+desc+"',preco = "+preco+",quantidade = "+quant+" where id ="+id+";");
            System.out.println(linhas);
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
        } finally {
//Libero os recursos usados
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
    }
} // fim da classe ClienteDAO
