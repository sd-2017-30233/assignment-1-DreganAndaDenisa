/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Anda
 */
public class AccountGateway {
    
     private Connection conn;
  private CallableStatement statement;
  private ResultSet resultSet;
 // private CallableStatement callableStatement;

  public AccountGateway(Connection connection) {
    this.conn = DatabaseConnectionController.getConnection();
  }

    
    public ArrayList<Object> AllAccounts(){
        ArrayList<Object> returnStatement = new ArrayList<Object>();

		try {

			String statement = "SELECT * FROM account";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
                             Object[] c=new Object[6];
				c[0]=rs.getInt(1);
                                c[1]=rs.getString(2);
                                c[2]=rs.getDouble(3);
                                c[3]=rs.getString(3);
                                c[4]=rs.getInt(4);
                                c[5]=rs.getInt(5);
                            
				returnStatement.add(c);			
			}
		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}

		return returnStatement;
		
	}
   
	public void createAccount(Integer ida,String typea,Double amount,String creat_date,Integer ide,Integer idc) {

		try {

			String statement = "INSERT INTO `account` (`ida`,`typea`,`amount`,`creat_date`,`ide`,`idc`) VALUES (?,?,?,?,?,?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
                        dbStatement.setInt(1,ida);
			dbStatement.setString(2,typea);
                        dbStatement.setDouble(3,amount);
                        dbStatement.setString(4,creat_date);
                        dbStatement.setInt(5,ide);
                        dbStatement.setInt(6,idc);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void updateAccount(Integer ida, String typea) {

		try {

			String statement = "UPDATE account SET typea=? where ida=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1,typea);
			dbStatement.setInt(2,ida);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}
        
        
public void deleteAccount(Integer ida) {

		try {

			String statement = "DELETE FROM account where ida=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, ida);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}
	}

public void transfer(Integer ida1,Integer ida2,Double sum)
{
    double from=0,to=0;
    System.out.println(from);
    try {
                        String statementt = "select amount from account where ida = ?";
                     
			PreparedStatement dbStatement = conn.prepareStatement(statementt);
                          
                        dbStatement.setInt(1,ida1);
                       
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
                            
                             from=rs.getDouble("amount");
                             System.out.println(from);
                               String statemennt1 = "UPDATE account SET amount=? where ida=?";
			PreparedStatement dbStatemenntt1 = conn.prepareStatement(statemennt1);
			dbStatemenntt1.setDouble(1,from-sum);
			dbStatemenntt1.setInt(2,ida1);
			dbStatemenntt1.executeUpdate();
                      //  System.out.println(to+sum);
                        }
                               
                        
                        String statementt1 = "select amount from account where ida =? ";
			PreparedStatement dbStatementt = conn.prepareStatement(statementt1);
			dbStatementt.setInt(1,ida2);
                        ResultSet rs1 = dbStatementt.executeQuery();

			while(rs1.next()) {
                         to=rs1.getDouble("amount");   
                                   
                        String statemennt2 = "UPDATE account SET amount=? where ida=?";
			PreparedStatement dbStatemenntt2 = conn.prepareStatement(statemennt2);
			dbStatemenntt2.setDouble(1,to+sum);
			dbStatemenntt2.setInt(2,ida2);
			dbStatemenntt2.executeUpdate();
                        }
                                //System.out.println(amountt1+sum);
                       
                        }
                        
    
    
                        
        
       
    
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

public void procesarefactura(Integer idaa,Double suma)
{
    double from=0;
    try {

                        String statementt = "select amount from account where ida = ?";
			PreparedStatement dbStatement = conn.prepareStatement(statementt);
                        dbStatement.setInt(1,idaa);
			ResultSet rs = dbStatement.executeQuery();

                        while(rs.next()) {
                         from=rs.getDouble("amount");   
                        }
                        if(from>suma)
                                //System.out.println(amountt1+sum);
                        {  String statemennt1 = "UPDATE account SET amount=? where ida=?";
			PreparedStatement dbStatemenntt1 = conn.prepareStatement(statemennt1);
			dbStatemenntt1.setDouble(1,from-suma);
			dbStatemenntt1.setInt(2,idaa);
			dbStatemenntt1.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Factura platita cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                               }
                else {JOptionPane.showMessageDialog(null, "Suma insuficienta!", null, JOptionPane.ERROR_MESSAGE);}; 
                        
			
                        
}
    catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
    
   
}

public void genreport(Integer ide,String data)
{
    Object[] msg={};
    
     try {

                        String statementt = "select account.ida, account.typea,account.amount from account where account.ide = '" + ide+ "'and creat_date = '" + data+ "';";
			PreparedStatement dbStatement = conn.prepareStatement(statementt);
                        dbStatement.setInt(1,ide);
                        dbStatement.setString(2,data);
			ResultSet rs = dbStatement.executeQuery();
   if(rs.next()==false) {JOptionPane.showMessageDialog(null, "Nu exista activitate!", null, JOptionPane.ERROR_MESSAGE);}
    
        
         while(rs.next()) {
                             Object[] c=new Object[6];
				c[0]=rs.getInt(1);
                                c[1]=rs.getString(2);
                                c[2]=rs.getDouble(3);
                                c[3]=rs.getString(4);
                                c[4]=rs.getInt(5);
                                c[5]=rs.getInt(6);
                            System.out.println("Id cont: "+c[0]+"Tip cont: "+c[1]+"Suma cont:"+c[2]);
                                 //msg = {"Id cont: ",c[0],"Tip cont: ",c[1],"Suma cont:", c[2]};
			}
         
     
                              //  Object[] msg = {"Id cont: ",c[0],"Tip cont: ",newAccount1.getAccountType(),"Suma cont:", newAccount1.getAccountAmount()};

    JOptionPane op = new JOptionPane(
    	msg,
    	JOptionPane.QUESTION_MESSAGE,
    	JOptionPane.DEFAULT_OPTION,
    	null,
    	null);
    JDialog dialog = op.createDialog("Info...");
    
    dialog.setVisible(true);
                               
     }
     
     catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
   
}


}