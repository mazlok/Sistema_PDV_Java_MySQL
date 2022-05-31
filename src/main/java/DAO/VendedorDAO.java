package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Produto;
import models.Vendedor;

/**
*
* @author Alexandre Machado
* @see controller.VendedorController
*/

public class VendedorDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
    private static final String LOGIN = "root"; //nome do usuário do banco
    private static final String SENHA = ""; //senha de acesso ao banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/nebulatech?useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;
    private static ResultSet rs;
    private static Statement instrucaoSQL;

    /**
     *
     * @param usuario objeto do tipo String
     * 
     */
    
    public static void login(String usuario) {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM vendedor where usuario = '"+usuario+"' ;");
            if (rs != null) {
                while (rs.next()) {
                    Vendedor.getInstance().setNome(rs.getString("nm_vendedor"));
                    Vendedor.getInstance().setUsuario(rs.getString("usuario"));
                    Vendedor.getInstance().setSenha(rs.getString("senha"));
                    Vendedor.getInstance().setCd_vendedor(rs.getInt("cd_vendedor"));
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
    } //fim do método consultarClientes
}// fim da classe VendedorDAO
