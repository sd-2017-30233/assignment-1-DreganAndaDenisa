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

/**
 *
 * @author Anda
 */
public class EmployeeGateway {
    
      private Connection conn;
  private CallableStatement statement;
  private ResultSet resultSet;
 // private CallableStatement callableStatement;

  public EmployeeGateway(Connection connection) {
    this.conn = DatabaseConnectionController.getConnection();
  }

    
  
  
  
  public ArrayList<Object> AllEmployees(){

      
      
		ArrayList<Object> returnStatement = new ArrayList<Object>();

		try {

			String statement = "SELECT * FROM employee";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

                        
			while(rs.next()) {
                            Object[] c=new Object[4];
				c[0]=rs.getInt(1);
                                c[1]=rs.getString(2);
                                c[2]=rs.getString(3);
                                c[3]=rs.getInt(4);
                                
                                returnStatement.add(c);
                               			
			}
		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}

		return returnStatement;
		
	}
 
  
  
  
  
  
  
   
	public void createEmployee(Integer ide,String namee,Integer age,String empl_date) {

		try {

			String statement = "INSERT INTO `employee` (`ide`,`namee`,`age`,`empl_date`) VALUES (?,?,?,?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
                        dbStatement.setInt(1,ide);
			dbStatement.setString(2,namee);
                        dbStatement.setInt(3,age);
                        dbStatement.setString(4,empl_date);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void updateEmployee(Integer ide, String namee) {

		try {

			String statement = "UPDATE employee SET namee=? where ide=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1,namee);
			dbStatement.setInt(2,ide);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}
        
        
public void deleteEmployee(Integer ide) {

		try {

			String statement = "DELETE FROM employee where ide=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, ide);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}
	}
    
   
    
}
