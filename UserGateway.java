/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anda
 */
public class UserGateway {
        private Connection conn;
  private CallableStatement statement;
  private ResultSet resultSet;
 // private CallableStatement callableStatement;

  public UserGateway(Connection connection) {
    this.conn = DatabaseConnectionController.getConnection();
  }

    public boolean verifica(String username,String password)
    {
        boolean ok=false;
         try {

                        String statementt = "select passworduser from user where usernameuser = '" + username+ "';";
			PreparedStatement dbStatement = conn.prepareStatement(statementt);
			ResultSet rs = dbStatement.executeQuery();
                while(rs.next()) {
				String pass = rs.getString("passworduser");
                                 if (password.equals(pass)) ok=true; 
                                 else ok=false;
    }
         }
    catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
          return ok;
}
}
