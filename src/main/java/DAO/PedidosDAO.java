package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Pedido;
import models.RelAnalitico;
import models.RelSintetico;

/**
 *
 * @author Alexandre Machado
 * @see controller.PedidosController
 */
public class PedidosDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
    private static final String LOGIN = "root"; //nome do usuário do banco
    private static final String SENHA = ""; //senha de acesso ao banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/nebulatech?useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;
    private static ResultSet rs;
    private static Statement instrucaoSQL;

    /**
     *
     * @param vendedor objeto do tipo String
     * @return int
     */
    public static int vendasPorVendedor(String vendedor) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT COUNT(*) FROM pedido where cd_vendedor = '" + vendedor + "' ;");
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("DAO.PedidosDAO.vendasPorVendedor()");
                    return rs.getInt("count(*)");
                }
            } else {
                throw new SQLException();
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
        return 0;
    } //fim do método consultarClientes

    /**
     *
     * @param cd_vendedor objeto do tipo Integer
     * @param cd_cliente objeto do tipo Integer
     * @param total
     * @return int -1: falha
     */
    public static int criarPedido(int cd_vendedor, int cd_cliente, float total) {
        int codPedido = -1;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("insert into pedido (cd_vendedor, cd_cliente, total, dataVenda) values ( " + cd_vendedor + ", " + cd_cliente + ", " + total+ ", current_date);");
            if (linhas == 1) {
                codPedido = codigoDoUltimoPedido(cd_vendedor, cd_cliente);
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
        return codPedido;
    }//fim do método criarPedido

    /**
     *
     * @param cd_produto objeto do tipo Integer
     * @param cd_pedido objeto do tipo Integer
     * @param quantidade objeto do tipo Integer
     *
     */
    public static void requisitarProduto(int cd_produto, int cd_pedido, int quantidade) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            int linhas = instrucaoSQL.executeUpdate("insert into pedido_detalhe (cd_produto, cd_pedido, quantidade) values (" + cd_produto + ", " + cd_pedido + ", " + quantidade + ");");
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
    }//fim do método criarPedido

    /**
     *
     * @param cd_vendedor objeto do tipo Integer
     * @param cd_cliente objeto do tipo Integer
     * @return int 0: falha
     *
     */
    public static int codigoDoUltimoPedido(int cd_vendedor, int cd_cliente) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT cd_pedido FROM pedido where cd_vendedor = " + cd_vendedor + " AND cd_cliente = " + cd_cliente + " ORDER BY cd_pedido DESC LIMIT 1;");

            if (rs != null) {
                while (rs.next()) {
                    return rs.getInt("cd_pedido");
                }
            } else {
                throw new SQLException();
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
        return 0;
    } //fim do método consultarClientes

    /**
     *
     * @param cd_vendedor objeto do tipo Integer
     * @param dataMin objeto do tipo Integer
     * @param dataMax objeto do tipo String
     * @return ArrayList<RelSintetico>
     *
     */
    public static ArrayList<Pedido> consultarPedido(String dataMin, String dataMax) {
        ArrayList<Pedido> listaRetorno = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("select * from pedido where dataVenda between '"+dataMin+"' AND '"+dataMax+"';");
            if (rs != null) {
                while (rs.next()) {
                    Pedido c = new Pedido();
                    c.setCd_cliente(rs.getInt("cd_cliente"));
                    c.setCd_pedido(rs.getInt("cd_pedido"));
                    c.setCd_vendedor(rs.getInt("cd_vendedor"));
                    c.setData(rs.getString("dataVenda"));
                    c.setTotal(rs.getInt("total"));
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
    } //fim do método consultarPedidos

    /**
     *
     * @param cd_pedido  objeto do tipo Integer
     * @return ArrayList<RelAnalitico>
     *
     */
    public static ArrayList<RelAnalitico> consultarPedidoDetalhado(int cd_pedido) {
        ArrayList<RelAnalitico> listaRetorno = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            CallableStatement cstmt = conexao.prepareCall("CALL p_RelAnalitico(?);");
            System.out.println(cstmt);
            cstmt.setInt(1, cd_pedido);
            System.out.println(cstmt);
            rs = cstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("DAO.PedidosDAO.consultarPedido()");
                    RelAnalitico c = new RelAnalitico();
                    c.setQuantidade(rs.getInt("quantidade"));
                    c.setNm_produto(rs.getString("nm_produto"));
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
    } //fim do método consultarPedidos
} // fim da classe PedidosDAO
