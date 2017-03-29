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
    
    
       public void addClient(Client parsedClient) {
		Integer idc = parsedClient.getClientId();
		String namec = parsedClient.getClientName();
                Integer card_number=parsedClient.getClientCardNr();
                String cnp = parsedClient.getClientCNP();
		String address = parsedClient.getClientAddress();
		ClientGateway clientSQL=new ClientGateway(conn);
		clientSQL.createClient(idc,namec,card_number,cnp,address);
		
	}
	
	public void updateClient(Client parsedClient) {
		Integer idc = parsedClient.getClientId();
		String address = parsedClient.getClientAddress();
		ClientGateway clientSQL=new ClientGateway(conn);
		clientSQL.updateClient(idc, address);
		
	}
        
           public ArrayList<Client> getAllClients() {
		ArrayList<Client> returnStatement = new ArrayList<Client>();
		ClientGateway clientSQL=new ClientGateway(conn);
		returnStatement = clientSQL.AllClients();
		return returnStatement;
		
	}
           
           
           
           
	

        public void addAccount(Account parsedAccount) {
		Integer ida = parsedAccount.getAccountId();
		String typea = parsedAccount.getAccountType();
                Double amount= parsedAccount.getAccountAmount();
		String creat_date = parsedAccount.getAccountDate();
                Integer ide=parsedAccount.getEmployeeId();
                Integer idc=parsedAccount.getClientId();
		AccountGateway accountSQL=new AccountGateway(conn);
		accountSQL.createAccount(ida,typea,amount,creat_date,ide,idc);
		
	}
        
        
        public void updateAccount(Account parsedAccount)
        {
            Integer ida=parsedAccount.getAccountId();
            String typea = parsedAccount.getAccountType();
            AccountGateway accountSQL=new AccountGateway(conn);
        accountSQL.updateAccount(ida,typea);
            
        }
        
        
       public void report(Account parsedAccount)
       {
           System.out.println("am ajuns in oper");
            Integer ide=parsedAccount.getEmployeeId();
            String data = parsedAccount.getAccountDate();
            AccountGateway accountSQL=new AccountGateway(conn);
        accountSQL.genreport(ide,data);
       }
        
        public void deleteAccount(Integer ida) {
		AccountGateway accountSQL=new AccountGateway(conn);
		accountSQL.deleteAccount(ida);
		
	}
    
   public void transferintreconturi(Account a1,Account a2,Double sum)
   {
       Integer ida1=a1.getAccountId();
       Integer ida2=a2.getAccountId();
       AccountGateway accountSQL=new AccountGateway(conn);
       accountSQL.transfer(ida1, ida2, sum);
   }
      
   public void procesarefacturaa(Account a,Double suma)
   {
       Integer ida1=a.getAccountId();
       AccountGateway accountSQL=new AccountGateway(conn);
       accountSQL.procesarefactura(ida1,suma);
   }
   
       public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> returnStatement = new ArrayList<Account>();
            AccountGateway accountSQL=new AccountGateway(conn);
		returnStatement = accountSQL.AllAccounts();
		return returnStatement;
		
	}
    
       
       
       
      public void addEmployee(Employee parsedEmployee) {
		Integer ide = parsedEmployee.getEmployeeId();
		String namee = parsedEmployee.getEmployeeName();
                Integer age=parsedEmployee.getEmployeeAge();
		String empl_date = parsedEmployee.getEmployeeDate();
		EmployeeGateway employeeSQL=new EmployeeGateway(conn);
		employeeSQL.createEmployee(ide,namee,age,empl_date);
		
	}
        
        
        public void updateEmployee(Employee parsedEmployee)
        {
            Integer ide=parsedEmployee.getEmployeeId();
		String namee = parsedEmployee.getEmployeeName();
            EmployeeGateway employeeSQL=new EmployeeGateway(conn);
        employeeSQL.updateEmployee(ide,namee);
            
        }
        
        public void deleteEmployee(Integer ide) {
		EmployeeGateway employeeSQL=new EmployeeGateway(conn);
		employeeSQL.deleteEmployee(ide);
		
	}
    
        
          public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> returnStatement = new ArrayList<Employee>();
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
