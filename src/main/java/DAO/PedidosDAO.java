/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import controller.ProdutosController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Produto;

/**
 *
 * @author alexa
 */
public class PedidosDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
    private static final String LOGIN = "root"; //nome do usuário do banco
    private static final String SENHA = ""; //senha de acesso ao banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/nebulatech?useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;
    private static ResultSet rs;
    private static Statement instrucaoSQL;

    public static int vendasPorVendedor(String vendedor) {
        try {
            //Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT COUNT(*) FROM pedido where cd_vendedor = '" + vendedor + "' ;");
            if (rs != null) {
                while (rs.next()) {
                    return rs.getInt("count(*)");
                }
            } else {
                throw new SQLException();
            }
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
        return 0;
    } //fim do método consultarClientes

    public static int criarPedido(int cd_vendedor, int cd_cliente) {
        int codPedido = -1;
        try {
//Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("insert into pedido (cd_vendedor, cd_cliente, dataVenda) values ( " + cd_vendedor + ", " + cd_cliente + ", current_date);");
            if (linhas == 1) {
                codPedido = codigoDoUltimoPedido(cd_vendedor, cd_cliente);
            }
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
        return codPedido;
    }//fim do método criarPedido

    public static void requisitarProduto(int cd_produto, int cd_pedido, int quantidade) {
        try {
//Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("insert into pedido_detalhe (cd_produto, cd_pedido, quantidade) values (" + cd_produto + ", " + cd_pedido + ", " + quantidade + ");");
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
    }//fim do método criarPedido
    
    public static int codigoDoUltimoPedido(int cd_vendedor, int cd_cliente) {
        try {
            //Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT cd_pedido FROM pedido where cd_vendedor = "+cd_vendedor+" AND cd_cliente = "+cd_cliente+" ORDER BY cd_pedido DESC LIMIT 1;");
            
            if (rs != null) {
                while (rs.next()) {
                    return rs.getInt("cd_pedido");
                }
            } else {
                throw new SQLException();
            }
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
        return 0;
    } //fim do método consultarClientes
}
