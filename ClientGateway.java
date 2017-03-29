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
  
  public ArrayList<Client> AllClients(){

      
      
		ArrayList<Client> returnStatement = new ArrayList<Client>();

		try {

			String statement = "SELECT * FROM client_info";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
				Integer idc = rs.getInt("idc");
				String namec = rs.getString("namec");
                                Integer card_number=rs.getInt("card_number");
                                String cnp=rs.getString("cnp");
                                 String address=rs.getString("address");
                                 Client newClient=new Client();
                                 newClient.setClientId(idc);
                                 newClient.setClientName(namec);
                                 newClient.setClientCardNr(card_number);
                                 newClient.setClientCNP(cnp);
                                 newClient.setClientAddress(address);
				returnStatement.add(newClient);			
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
                    //System.out.println("am ajuns in gate in try");
                        String statementt = "select max(idc) from client_info;";
			PreparedStatement dbStatement = conn.prepareStatement(statementt);
			ResultSet rs = dbStatement.executeQuery();
  // if(rs.next()==false) {JOptionPane.showMessageDialog(null, "Nu exista activitate!", null, JOptionPane.ERROR_MESSAGE);}
     while(rs.next()) {
       // System.out.println("am ajuns in gate in while");
				Integer idefromdb = rs.getInt("idc");
                                //System.out.println(idefromdb);
                                 Client newAccount1=new Client();
                                newAccount1.setClientId(idefromdb);
     
                                if(newAccount1.getClientId()!=idc){
			String statement = "INSERT INTO `client_info` (`idc`,`namec`,`card_number`,`cnp`,`address`) VALUES (?,?,?,?,?)";
			PreparedStatement dbStatementt = conn.prepareStatement(statement);
                        
                        dbStatementt.setInt(1,idc);
			dbStatementt.setString(2,namec);
                        dbStatementt.setInt(3,card_number);
                        dbStatementt.setString(4,cnp);
                        dbStatementt.setString(5,address);
			dbStatementt.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Clientul a fost adaugat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);}
                        else{JOptionPane.showMessageDialog(null, "Id existent !", null, JOptionPane.ERROR_MESSAGE);}
                                
                }}
		
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
