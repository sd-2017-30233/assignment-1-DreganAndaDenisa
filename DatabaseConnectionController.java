/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author Anda
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;


public class DatabaseConnectionController {
  private static Connection con;
   private String url = "jdbc:mysql://localhost:3306/tema";
	private	String uid = "root";
	private	String pw = "Dennnnnnnisa12@";
        private Integer pw1=0;


  public DatabaseConnectionController() {
    loadDriver();
    connectToDatabase();
  }

  public void loadDriver() {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    }
    catch (Exception exception) {
      JOptionPane.showMessageDialog(null, "Connection driver loading failed", "Error", JOptionPane.ERROR_MESSAGE);
    }
    System.out.println("e ok ");
  }

  public void connectToDatabase() {
    try {
      Connection conn = DriverManager.getConnection(url,uid,pw);
      DatabaseConnectionController.con = conn;
    }
    catch (Exception exception) {
      JOptionPane.showMessageDialog(null, "Establising database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void deconnectFromDatabase() {
    if (con != null) {
      try {
        con.close();
        con = null;
      }
      catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Closing database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public static Connection getConnection() {
    return con;
  }
}