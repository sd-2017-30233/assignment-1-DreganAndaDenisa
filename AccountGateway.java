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

    
    public ArrayList<Account> AllAccounts(){
        ArrayList<Account> returnStatement = new ArrayList<Account>();

		try {

			String statement = "SELECT * FROM account";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
				Integer ida = rs.getInt("ida");
				String typea = rs.getString("typea");
                                Double amount=rs.getDouble("amount");
                                String creat_date=rs.getString("creat_date");
                                Integer ide = rs.getInt("ide");
                                Integer idc = rs.getInt("idc");
                                Account newAccount=new Account();
                                newAccount.setAccountId(ida);
                                newAccount.setAccountType(typea);
                                newAccount.setAccountAmount(amount);
                                newAccount.setAccountDate(creat_date);
                                newAccount.setEmployeeId(ide);
                                newAccount.setClientId(idc);
                                
				returnStatement.add(newAccount);			
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
    try {

                        String statementt = "select amount from account where ida = '" + ida1+ "';";
			PreparedStatement dbStatement = conn.prepareStatement(statementt);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
				Double amountt = rs.getDouble("amount");
                                Account newAccount1=new Account();
                                newAccount1.setAccountAmount(amountt-sum);
                                System.out.println(amountt-sum);
                                if (amountt>=sum){
                                String statemennt = "UPDATE account SET amount=? where ida=?";
			PreparedStatement dbStatemenntt = conn.prepareStatement(statemennt);
			dbStatemenntt.setDouble(1,amountt-sum);
			dbStatemenntt.setInt(2,ida1);
			dbStatemenntt.executeUpdate();
                                 JOptionPane.showMessageDialog(null, "Transfer reusit intre conturi!", null, JOptionPane.INFORMATION_MESSAGE);}
                                else {JOptionPane.showMessageDialog(null, "Suma insuficienta!", null, JOptionPane.ERROR_MESSAGE);};
                        }
                        
                        String statementt1 = "select amount from account where ida = '" + ida2+ "';";
			PreparedStatement dbStatementt = conn.prepareStatement(statementt1);
			ResultSet rs1 = dbStatementt.executeQuery();

			while(rs1.next()) {
				Double amountt1 = rs1.getDouble("amount");
                                Account newAccount2=new Account();
                                newAccount2.setAccountAmount(amountt1+sum);
                                //System.out.println(amountt1+sum);
                                 String statemennt1 = "UPDATE account SET amount=? where ida=?";
			PreparedStatement dbStatemenntt1 = conn.prepareStatement(statemennt1);
			dbStatemenntt1.setDouble(1,amountt1+sum);
			dbStatemenntt1.setInt(2,ida2);
			dbStatemenntt1.executeUpdate();
                        }
                        
    
    }
                        
        
       
    
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

public void procesarefactura(Integer idaa,Double suma)
{
    try {

                        String statementt = "select amount from account where ida = '" + idaa+ "';";
			PreparedStatement dbStatement = conn.prepareStatement(statementt);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
				Double amountt = rs.getDouble("amount");
                                Account newAccount1=new Account();
                                newAccount1.setAccountAmount(amountt-suma);
                                //System.out.println(newAccount1.getAccountAmount());
                               if (amountt>=suma){
                        String statement = "UPDATE account SET amount=? where ida=?";
			PreparedStatement dbStatementt = conn.prepareStatement(statement);
			dbStatementt.setDouble(1,amountt-suma);
			dbStatementt.setInt(2,idaa);
			dbStatementt.executeUpdate();
                         JOptionPane.showMessageDialog(null, "Factura platita cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                               }
                else {JOptionPane.showMessageDialog(null, "Suma insuficienta!", null, JOptionPane.ERROR_MESSAGE);};  
                        }
                        
}
    catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
    
   
}

public void genreport(Integer ide,String data)
{
    
     try {

                        String statementt = "select account.ida, account.typea,account.amount from account where account.ide = '" + ide+ "'and creat_date = '" + data+ "';";
			PreparedStatement dbStatement = conn.prepareStatement(statementt);
			ResultSet rs = dbStatement.executeQuery();
   if(rs.next()==false) {JOptionPane.showMessageDialog(null, "Nu exista activitate!", null, JOptionPane.ERROR_MESSAGE);}
     while(rs.next()) {
        
				Integer ida = rs.getInt("ida");
                                String typea=rs.getString("typea");
                                Double amount=rs.getDouble("amount");
                                Account newAccount1=new Account();
                                newAccount1.setAccountId(ida);
                                newAccount1.setAccountType(typea);
                                newAccount1.setAccountAmount(amount);
                                Object[] msg = {"Id cont: ",newAccount1.getAccountId(),"Tip cont: ",newAccount1.getAccountType(),"Suma cont:", newAccount1.getAccountAmount()};

    JOptionPane op = new JOptionPane(
    	msg,
    	JOptionPane.QUESTION_MESSAGE,
    	JOptionPane.DEFAULT_OPTION,
    	null,
    	null);
    JDialog dialog = op.createDialog("Info...");
    
    dialog.setVisible(true);
                               
     }
     }
     catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
   
}


}