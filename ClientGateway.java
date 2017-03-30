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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anda
 */
public class ClientGateway {
      private Connection conn;
  private CallableStatement statement;
  private ResultSet resultSet;
 // private CallableStatement callableStatement;

  public ClientGateway(Connection connection) {
    this.conn = DatabaseConnectionController.getConnection();
  }
  
  public ArrayList<Object> AllClients(){

      
      
		ArrayList<Object> returnStatement = new ArrayList<Object>();

		try {

			String statement = "SELECT * FROM client_info";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
                            Object[] c=new Object[5];
				c[0]=rs.getInt(1);
                                c[1]=rs.getString(2);
                                c[2]=rs.getInt(3);
                                c[3]=rs.getString(4);
                                c[4]=rs.getString(5);
                                
                                returnStatement.add(c);
                               			
			}
		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}

		return returnStatement;
		
	}
 
	public void createClient(Integer idc,String namec,Integer card_number,String cnp,String address) {
System.out.println("am ajuns in gate");
		try{
                  
                             
			String statement = "INSERT INTO `client_info` (`idc`,`namec`,`card_number`,`cnp`,`address`) VALUES (?,?,?,?,?)";
			PreparedStatement dbStatementt = conn.prepareStatement(statement);
                        
                        dbStatementt.setInt(1,idc);
			dbStatementt.setString(2,namec);
                        dbStatementt.setInt(3,card_number);
                        dbStatementt.setString(4,cnp);
                        dbStatementt.setString(5,address);
			dbStatementt.executeUpdate();
                             //   JOptionPane.showMessageDialog(null, "Clientul a fost adaugat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                 
                               
                }
		
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void updateClient(Integer idc, String address) {

		try {

			String statement = "UPDATE client_info SET address=? where idc=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1,address);
			dbStatement.setInt(2,idc);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}
 
      
     
     
        
        
}
