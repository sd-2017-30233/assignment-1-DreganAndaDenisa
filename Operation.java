/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Anda
 */
public class Operation {
    
    private Connection conn;
    
       public void addClient(Integer idc,String namec,Integer card_number,String CNP,String address) {
		
		ClientGateway clientSQL=new ClientGateway(conn);
		clientSQL.createClient(idc,namec,card_number,CNP,address);
		
	}
	
	public void updateClient(Integer idc, String address) {

		ClientGateway clientSQL=new ClientGateway(conn);
		clientSQL.updateClient(idc, address);
		
	}
        
           public ArrayList<Object> getAllClients() {
		ArrayList<Object> returnStatement = new ArrayList<Object>();
		ClientGateway clientSQL=new ClientGateway(conn);
              
		returnStatement = clientSQL.AllClients();
		return returnStatement;
		
	}
           
           
           
           
	

        public void addAccount(Integer ida,String typea,Double amount,String creat_date,Integer ide,Integer idc) {
		
		AccountGateway accountSQL=new AccountGateway(conn);
		accountSQL.createAccount(ida,typea,amount,creat_date,ide,idc);
		
	}
        
        
        public void updateAccount(Integer ida,String typea)
        {
            
            AccountGateway accountSQL=new AccountGateway(conn);
        accountSQL.updateAccount(ida,typea);
            
        }
        
        
       public void report(Integer ide,String data)
       {
           System.out.println("am ajuns in oper");
            AccountGateway accountSQL=new AccountGateway(conn);
        accountSQL.genreport(ide,data);
       }
        
        public void deleteAccount(Integer ida) {
		AccountGateway accountSQL=new AccountGateway(conn);
		accountSQL.deleteAccount(ida);
		
	}
    
   public void transferintreconturi(Integer ida1,Integer ida2,Double sum)
   {
       AccountGateway accountSQL=new AccountGateway(conn);
       accountSQL.transfer(ida1, ida2, sum);
   }
      
   public void procesarefacturaa(Integer ida1,Double suma)
   {
       
       AccountGateway accountSQL=new AccountGateway(conn);
       accountSQL.procesarefactura(ida1,suma);
   }
   
       public ArrayList<Object> getAllAccounts() {
		ArrayList<Object> returnStatement = new ArrayList<Object>();
            AccountGateway accountSQL=new AccountGateway(conn);
		returnStatement = accountSQL.AllAccounts();
		return returnStatement;
		
	}
    
       
       
       
      public void addEmployee(Integer ide,String namee,Integer age,String empl_date) {
		
		EmployeeGateway employeeSQL=new EmployeeGateway(conn);
		employeeSQL.createEmployee(ide,namee,age,empl_date);
		
	}
        
        
        public void updateEmployee(Integer ide,String namee)
        {
            EmployeeGateway employeeSQL=new EmployeeGateway(conn);
        employeeSQL.updateEmployee(ide,namee);
            
        }
        
        public void deleteEmployee(Integer ide) {
		EmployeeGateway employeeSQL=new EmployeeGateway(conn);
		employeeSQL.deleteEmployee(ide);
		
	}
    
        
          public ArrayList<Object> getAllEmployees() {
		ArrayList<Object> returnStatement = new ArrayList<Object>();
		EmployeeGateway employeeSQL=new EmployeeGateway(conn);
		returnStatement = employeeSQL.AllEmployees();
		return returnStatement;
		
	}
          
          
          public boolean verificaadmin(Admin a)
          {
              String username=a.getAdminUsername();
       String password=a.getAdminPassword();
       AdminGateway adminSQL=new AdminGateway(conn);
       boolean ok=adminSQL.verifica(username,password);
       return ok;
          }
          
            public boolean verificauser(User a)
          {
              String username=a.getUserUsername();
       String password=a.getUserPassword();
       UserGateway userSQL=new UserGateway(conn);
       boolean ok=userSQL.verifica(username,password);
       return ok;
          }
          

        
}
