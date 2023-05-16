/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class DBUtils {
    public static Connection getConnection() {
        Connection con = null;
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=KhaoSatQuanNhan;encrypt=false;";
                con = DriverManager.getConnection(connectionUrl, "sa", "phuc0985531639");
		System.out.println("Connection Success !");
        } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Connection Faild !");
        }
        return con;
    }
    
    public static void closeConnection(Connection conn, PreparedStatement preparedStatement) {
        try {
            if (conn != null) {
                    conn.close();
            }
            if (preparedStatement != null) {
                    preparedStatement.close();
            }
        } catch (SQLException e) {
        }
    }
    
    public static void main(String[] args) {
	DBUtils.getConnection();
    }
}
