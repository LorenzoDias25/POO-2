package Util;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoBD {
    
    static String name;
    static String user;
    static String pass;
    
    public static Connection getConnection() {
        Connection conexao = null;
          
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + name, user , pass);
            System.out.println("Conexão ok");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conexao = null;
        }

        return conexao;

    }

    public static void dadosbd(){
        name = JOptionPane.showInputDialog("Nome: ");
        user = JOptionPane.showInputDialog("Usuario: ");
        pass = JOptionPane.showInputDialog("Senha: ");
        
        getConnection();
    }
    
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void close(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
