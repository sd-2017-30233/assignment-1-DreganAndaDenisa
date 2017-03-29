/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anda
 */
public class GraphicControl extends JFrame {
 private Statement statement;
     private ResultSet resultSet;
     private DatabaseConnectionController conn=new DatabaseConnectionController();
    
   
      private JButton admin=new JButton("Administrator"); 
      private JButton backadmin1=new JButton("Back"); 
       private JButton backadmin2=new JButton("Back");
        private JButton backadmin3=new JButton("Back");
	private JButton user=new JButton("User"); 
        private JButton backuser1=new JButton("Back"); 
        private JButton backuser2=new JButton("Back"); 
        private JButton backuser3=new JButton("Back"); 
        private JButton ok=new JButton("handicapat");
        private JButton okadmin=new JButton("Logare admin"); 
	private JButton okuser=new JButton("Logare user"); 
        
        
         private JButton addclient=new JButton("Adaug. client"); 
	private JButton updateclient=new JButton("Actual. client"); 
        private JButton addaccount=new JButton("Adaug. cont"); 
	private JButton updateaccount=new JButton("Actual. cont"); 
        private JButton delaccount=new JButton("Sterge cont"); 
        private JButton viewclient=new JButton("Vizual. clienti"); 
        private JButton viewaccount=new JButton("Vizual. conturi"); 
            private JButton transfer=new JButton("Transfer bani"); 
        private JButton bills=new JButton("Procesare factura"); 
        
        private JButton addempl=new JButton("Adaug. employee"); 
	private JButton updateempl=new JButton("Actual. employee"); 
        private JButton delempl=new JButton("Sterge employee"); 
        private JButton report=new JButton("Report employee & date"); 
         private JButton viewempl=new JButton("Vizual. employees"); 
        
        private JPanel mainPanel=new JPanel();
        private JPanel userPanel=new JPanel();
	private JPanel adminPanel=new JPanel();
        
        private JPanel userlogatPanel=new JPanel();
	private JPanel adminlogatPanel=new JPanel();
        
        private JPanel viewclientpanel=new JPanel();
           private JPanel viewaccountpanel=new JPanel();
           
        private JTextField name=new JTextField();
	private JTextField pass=new JTextField();
        
        private JTextField name1=new JTextField();
	private JTextField pass1=new JTextField();
        
        private JTextField idc=new JTextField();
	private JTextField namec=new JTextField();
        private JTextField cardnr=new JTextField();
	private JTextField cnp=new JTextField();
        private JTextField addr=new JTextField();
	private JTextField ida=new JTextField();
        private JTextField ida1=new JTextField();
        private JTextField typea=new JTextField();
	private JTextField amount=new JTextField();
        private JTextField creatdate=new JTextField();
        private JTextField idepta=new JTextField();
        private JTextField sumafactura=new JTextField();
        private JTextField sumatransfer=new JTextField();
        
        private JTextField ide=new JTextField();
	private JTextField namee=new JTextField();
        private JTextField age=new JTextField();
	private JTextField empldate=new JTextField();
        private JTextField reportdate=new JTextField();
        
        
        
         private JLabel idclabel=new JLabel("Id client : ");
        private JLabel nameclabel=new JLabel("Nume client : ");
        private JLabel cardnrlabel=new JLabel("Nr card client: ");
        private JLabel cnplabel=new JLabel("CNP : ");
        private JLabel addrlabel=new JLabel("Adresa client : ");
        private JLabel idalabel=new JLabel("Id cont : ");
        private JLabel idalabel1=new JLabel("Id cont 2 : ");
        private JLabel typealabel=new JLabel("Tip cont : ");
        private JLabel amountlabel=new JLabel("Suma cont : ");
        private JLabel creatdatelabel=new JLabel("Data creare cont : ");
        private JLabel ideptalabel=new JLabel("Id employee : ");
         private JLabel sumafacturalabel=new JLabel("Suma factura : ");
           private JLabel sumatransferlabel=new JLabel("Suma transfer : ");
        
        private JLabel idelabel=new JLabel("Id employee : ");
        private JLabel nameelabel=new JLabel("Nume employee : ");
        private JLabel agelabel=new JLabel("Varsta employee : ");
        private JLabel empldatelabel=new JLabel("Data angajarii : ");
        private JLabel reportdatelabel=new JLabel("Data pt report : ");
        
        
        
            private JLabel hiall=new JLabel("Hi all !!! ");
             private JLabel hiadmin=new JLabel("Hi admin !!! ");
              private JLabel hiuser=new JLabel("Hi user !!! ");
        private JLabel usernameLabel=new JLabel("Username : ");
        private JLabel passwordLabel=new JLabel("Parola : ");
        private JLabel usernameLabel1=new JLabel("Username : ");
        private JLabel passwordLabel1=new JLabel("Parola : ");
        
        Object columnNamesClient[] = {"Id","Nume", "Card Nr","CNP","Address" };
        Object columnNamesAccount[] = {"Id","Type", "Amount","Date creat","Client Id","Employee Id" };
        Object columnNamesEmpl[] = {"Id","Nume", "Age","Date empl" };
         private String[][] clientData ={};
        private JTable clientTable;
        private JTable accountTable;
        private JTable employeeTable;
        private DefaultTableModel model ;
        
        
        
         private ClientGateway a;
         private AccountGateway b;
         private EmployeeGateway em;
         
        private String url = "jdbc:mysql://localhost:3306/tema";
	private	String uid = "root";
	private	String pw = "Dennnnnnnisa12@";
        private Integer pw1=0;
	private BufferedReader reader;
	private Connection connection;
        
        GraphicControl() {


        // try {
             a = new ClientGateway(DatabaseConnectionController.getConnection());
   b= new AccountGateway(DatabaseConnectionController.getConnection());
   em= new EmployeeGateway(DatabaseConnectionController.getConnection());
             this.setLayout(null);
             this.add(mainPanel);
this.add(userPanel);
this.add(adminPanel);
this.add(adminlogatPanel);
this.add(userlogatPanel);
this.add(viewclientpanel);
this.add(viewaccountpanel);


 mainPanel.setBounds(0, 0, 800, 700);
mainPanel.setVisible(true);
mainPanel.setBackground(new Color(255,240,200));
mainPanel.setLayout(null);
admin.setBounds(300,120,150,30);
user.setBounds(300,200, 150, 30);
hiall.setBounds(340,300,400,100);
hiall.setFont(new Font("Serif", Font.BOLD, 20));
hiall.setForeground(Color.ORANGE);
mainPanel.add(admin);
mainPanel.add(user);
mainPanel.add(hiall);
admin.addActionListener(new Control());
user.addActionListener(new Control());

userPanel.setBounds(0, 0, 800, 700);
userPanel.setVisible(false);
userPanel.setBackground(new Color(255,230,200));
userPanel.setLayout(null);
okuser.setBounds(330,350,100,40);
backuser1.setBounds(330,400,100,40);
name.setBounds(350,120,100,30);
pass.setBounds(350,190,100,30);
usernameLabel.setBounds(250, 80, 100, 100);
passwordLabel.setBounds(250, 150, 100, 100);
hiuser.setBounds(340,230,400,100);
hiuser.setFont(new Font("Serif", Font.BOLD, 20));
hiuser.setForeground(Color.ORANGE);
userPanel.add(okuser);
userPanel.add(name);
userPanel.add(pass);
userPanel.add(usernameLabel);
userPanel.add(passwordLabel);
userPanel.add(backuser1);
userPanel.add(hiuser);
okuser.addActionListener(new Control());
backuser1.addActionListener(new Control());


adminPanel.setBounds(0, 0, 800, 700);
adminPanel.setVisible(false);
adminPanel.setBackground(new Color(255,230,200));
adminPanel.setLayout(null);
okadmin.setBounds(330,350,100,40);
backadmin1.setBounds(330,400,100,40);
name1.setBounds(350,120,100,30);
pass1.setBounds(350,190,100,30);
usernameLabel1.setBounds(250, 80, 100, 100);
passwordLabel1.setBounds(250, 150, 100, 100);
hiadmin.setBounds(340,230,400,100);
hiadmin.setFont(new Font("Serif", Font.BOLD, 20));
hiadmin.setForeground(Color.ORANGE);
adminPanel.add(okadmin);
adminPanel.add(hiadmin);
adminPanel.add(name1);
adminPanel.add(pass1);
adminPanel.add(backadmin1);
adminPanel.add(usernameLabel1);
adminPanel.add(passwordLabel1);
okadmin.addActionListener(new Control());
backadmin1.addActionListener(new Control());


  userlogatPanel.setBounds(0, 0, 800, 700);
userlogatPanel.setVisible(false);
userlogatPanel.setBackground(new Color(255,220,200));
userlogatPanel.setLayout(null);

addclient.setBounds(500,50,100,30);
updateclient.setBounds(500,100,100,30);
addaccount.setBounds(500,400,100,30);
updateaccount.setBounds(500, 450, 100, 30);
delaccount.setBounds(500, 500, 100, 30);
viewclient.setBounds(500,150,100,30);
viewaccount.setBounds(500,550,100,30);
transfer.setBounds(620,400,150,30);
bills.setBounds(620,450,150,30);
backuser2.setBounds(620,500,150,30);

idc.setBounds(200,50,100,30);
namec.setBounds(200,100,100,30);
cardnr.setBounds(200,150,100,30);
cnp.setBounds(200, 200, 100, 30);
addr.setBounds(200, 250, 100, 30);
ida.setBounds(200,350,100,30);
ida1.setBounds(370,350,100,30);
typea.setBounds(200,400,100,30);
amount.setBounds(200, 450, 100, 30);
creatdate.setBounds(200, 500, 100, 30);
idepta.setBounds(200,550,100,30);
sumafactura.setBounds(200,600,100,30);
sumatransfer.setBounds(600,350,100,30);
idclabel.setBounds(100,50,100,30);
nameclabel.setBounds(100,100,100,30);
cardnrlabel.setBounds(100,150,100,30);
cnplabel.setBounds(100, 200, 100, 30);
addrlabel.setBounds(100, 250, 100, 30);
idalabel.setBounds(100,350,100,30);
idalabel1.setBounds(310,350,100,30);
typealabel.setBounds(100,400,100,30);
amountlabel.setBounds(100, 450, 100, 30);
creatdatelabel.setBounds(100, 500, 100, 30);
ideptalabel.setBounds(100,550,100,30);
sumafacturalabel.setBounds(100,600,100,30);
sumatransferlabel.setBounds(500,350,100,30);
userlogatPanel.add(backuser2);
userlogatPanel.add(bills);
userlogatPanel.add(transfer);
userlogatPanel.add(viewclient);
userlogatPanel.add(viewaccount);
userlogatPanel.add(addclient);
userlogatPanel.add(updateclient);
userlogatPanel.add(addaccount);
userlogatPanel.add(updateaccount);
userlogatPanel.add(delaccount);
userlogatPanel.add(idc);
userlogatPanel.add(idclabel);
userlogatPanel.add(namec);
userlogatPanel.add(nameclabel);
userlogatPanel.add(cardnr);
userlogatPanel.add(cardnrlabel);
userlogatPanel.add(cnp);
userlogatPanel.add(cnplabel);
userlogatPanel.add(addr);
userlogatPanel.add(addrlabel);
userlogatPanel.add(ida);
userlogatPanel.add(idalabel);
userlogatPanel.add(ida1);
userlogatPanel.add(idalabel1);
userlogatPanel.add(typea);
userlogatPanel.add(typealabel);
userlogatPanel.add(amount);
userlogatPanel.add(amountlabel);
userlogatPanel.add(creatdate);
userlogatPanel.add(creatdatelabel);
userlogatPanel.add(idepta);
userlogatPanel.add(ideptalabel);
userlogatPanel.add(sumafactura);
userlogatPanel.add(sumafacturalabel);
userlogatPanel.add(sumatransfer);
userlogatPanel.add(sumatransferlabel);
addclient.addActionListener(new Control());
updateclient.addActionListener(new Control());
addaccount.addActionListener(new Control());
updateaccount.addActionListener(new Control());
delaccount.addActionListener(new Control());
viewclient.addActionListener(new Control());
viewaccount.addActionListener(new Control());
transfer.addActionListener(new Control());
bills.addActionListener(new Control());
backuser2.addActionListener(new Control());

 adminlogatPanel.setBounds(0, 0, 800, 700);
adminlogatPanel.setVisible(false);
adminlogatPanel.setBackground(new Color(255,220,200));
adminlogatPanel.setLayout(null);

addempl.setBounds(500,100,150,30);
updateempl.setBounds(500,200,150,30);
delempl.setBounds(500,300,150,30);
report.setBounds(500,400,150,30);
viewempl.setBounds(500,500,150,30);

ide.setBounds(200,100,100,30);
namee.setBounds(200,150,100,30);
age.setBounds(200,200,100,30);
empldate.setBounds(200, 250, 100, 30);
reportdate.setBounds(200,300,100,30);
backadmin2.setBounds(200,350,100,30);


idelabel.setBounds(100,100,100,30);
nameelabel.setBounds(100,150,100,30);
agelabel.setBounds(100,200,100,30);
empldatelabel.setBounds(100, 250, 100, 30);
reportdatelabel.setBounds(100,300,100,30);

adminlogatPanel.add(backadmin2);
adminlogatPanel.add(ide);
adminlogatPanel.add(idelabel);
adminlogatPanel.add(namee);
adminlogatPanel.add(nameelabel);
adminlogatPanel.add(age);
adminlogatPanel.add(agelabel);
adminlogatPanel.add(empldate);
adminlogatPanel.add(empldatelabel);
adminlogatPanel.add(addempl);
adminlogatPanel.add(updateempl);
adminlogatPanel.add(delempl);
adminlogatPanel.add(reportdatelabel);
adminlogatPanel.add(reportdate);
adminlogatPanel.add(report);
adminlogatPanel.add(viewempl);


addempl.addActionListener(new Control());
updateempl.addActionListener(new Control());
delempl.addActionListener(new Control());
report.addActionListener(new Control());
viewempl.addActionListener(new Control());
backadmin2.addActionListener(new Control());




          /*  viewclientpanel.setLayout(new GridBagLayout());
            viewclientpanel.setBackground(Color.pink);
            GridBagConstraints constraint = new GridBagConstraints();
            constraint.insets = new Insets(5, 10, 5, 10);
            
            clientTable = new JTable(clientTableModel);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 4;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		JScrollPane scrollPaneC = new JScrollPane(clientTable);
		clientTable.getTableHeader().setReorderingAllowed(false);
                clientTable.setBackground(Color.red);
		clientTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		viewclientpanel.add(scrollPaneC,constraint);
                
                ok = new JButton("Creare Student");
                ok.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		ok.addActionListener(new GraphicControl.Control());
		constraint.gridx = 3;
		constraint.gridy = 8;
		constraint.gridwidth = 1;
		mainPanel.add(ok, constraint);
                viewclientpanel.add(ok);*/
            
              


                

	this.setPreferredSize(new Dimension(800, 700));
	this.setTitle("Bank");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
             /*this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1000, 450));
		mainPanel = new JPanel();
		mainPanel.setVisible(true);

		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(Color.gray);
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(5, 10, 5, 10);
                
            
                   admin = new JButton("Administrator");
                admin.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		admin.addActionListener(new GraphicControl.Control());
		constraint.gridx = 8;
		constraint.gridy = 8;
		constraint.gridwidth = 1;
		mainPanel.add(admin, constraint);
                
                 user = new JButton("User");
                user.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		user.addActionListener(new GraphicControl.Control());
		constraint.gridx = 9;
		constraint.gridy = 9;
		constraint.gridwidth = 1;
		mainPanel.add(user, constraint);
                
                 name = new JTextField();
		name.setText("Username");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 0;
		constraint.gridy = 5;
		constraint.gridwidth = 2;
		mainPanel.add(name, constraint);
                
                 pass = new JTextField();
		pass.setText("Password");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 4;
		constraint.gridy = 5;
		constraint.gridwidth = 2;
		mainPanel.add(pass, constraint);
                
                
               mainPanel.setVisible(true);
		this.setResizable(false);
		this.add(mainPanel, BorderLayout.PAGE_START);
		this.pack();  
              		

//this.add(userPanel);
//this.add(adminPanel);*/
         //    updateTableClient();
}
        
      /*   public void updateTableClient()  { 
		Operation op = new Operation();
		this.clientlist = op.getAllClients();
		int size = clientlist.size();
                System.out.println(size);
		String[][] row = new String[size+2][6];
		for(int line=0;line<size;line++){
			String c0 = clientlist.get(line).getClientId().toString();
			String c1 = clientlist.get(line).getClientName();
			String c2 = clientlist.get(line).getClientCardNr().toString();
                        String c3=clientlist.get(line).getClientCNP();
                        String c4=clientlist.get(line).getClientAddress();
                        

			row[line][0] = c0;
			row[line][1] = c1;
			row[line][2] = c2;
                        row[line][3]=c3;
                        row[line][4]=c4;
		}
		this.clientData = row;
		this.clientTableModel.setData(row);
		this.repaint();
               

	}*/
          public class Control implements ActionListener  {

		private Integer selectFlag = 0;
		private Operation operations = new Operation();
		
		@Override
		public void actionPerformed(ActionEvent e)  {
			
                    if (e.getSource() == user) {
		userPanel.setVisible(true);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }
                    
			if (e.getSource() == admin) {
				
		 userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(true);
                  adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                
} 
                        
                         if (e.getSource() == backuser1) {
		userPanel.setVisible(false);
                mainPanel.setVisible(true);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }
                         
                           if (e.getSource() == backuser2) {
		userPanel.setVisible(true);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }
                           
                           if (e.getSource() == backuser3) {
		userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(true);
                    }
                         
                          if (e.getSource() == backadmin1) {
		userPanel.setVisible(false);
                mainPanel.setVisible(true);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }
                          
                          if (e.getSource() == backadmin2) {
		userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(true);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }
                          if (e.getSource() == backadmin3) {
		userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(true);
                userlogatPanel.setVisible(false);
                    }
                          
                        if (e.getSource() == okadmin) {
                            String adminname = name1.getText();
                            String adminpass = pass1.getText();
                            Admin parsedAdmin= new Admin();
			       parsedAdmin.setAdminUsername(adminname);
                               parsedAdmin.setAdminPassword(adminpass);
				if (operations.verificaadmin(parsedAdmin))
                                {
		 userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                  adminlogatPanel.setVisible(true);
                userlogatPanel.setVisible(false);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Logare esuata !", null, JOptionPane.ERROR_MESSAGE); 
                                }
                
}
                        if (e.getSource() == okuser) {
				 String username = name.getText();
                            String userpass = pass.getText();
                            User parsedUser= new User();
			       parsedUser.setUserUsername(username);
                               parsedUser.setUserPassword(userpass);
				if (operations.verificauser(parsedUser))
                                {
		 userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                  adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(true);
                                }
                else {
                                    JOptionPane.showMessageDialog(null, "Logare esuata !", null, JOptionPane.ERROR_MESSAGE); 
                                }
} 
                          if (e.getSource() == viewaccount) {
				Object data[][] ={};
		  model=new DefaultTableModel(data,columnNamesAccount);
		   accountTable= new JTable(model);
		   accountTable.setEnabled(false);
		   JDialog dialog=new JDialog();
		   dialog.setPreferredSize(new Dimension(650,300));
		 
		  
		    dialog.setLocationRelativeTo(null);
		    dialog.setTitle("Accounts info");
		   for(Object x:b.AllAccounts())
		   {Account c=(Account)x;
			   Object[] obj={c.getAccountId(),c.getAccountType(),c.getAccountAmount(),c.getAccountDate(),c.getClientId(),c.getEmployeeId()};
			   model.addRow(obj);
			   model.fireTableDataChanged();
		   }
                          
		   

		   JScrollPane scrollPane3 = new JScrollPane(accountTable);
		   scrollPane3.setBounds(10, 50, 950, 120);
		    scrollPane3.setEnabled(false);
		    
		    
		   dialog.add(scrollPane3);
		   dialog.pack();
		   dialog.setVisible(true);
		
	
                          }
          
                         if (e.getSource() == viewclient) {
				Object data[][] ={};
		  model=new DefaultTableModel(data,columnNamesClient);
		   clientTable= new JTable(model);
		   clientTable.setEnabled(false);
		   JDialog dialog=new JDialog();
		   dialog.setPreferredSize(new Dimension(650,300));
		 
		  
		    dialog.setLocationRelativeTo(null);
		    dialog.setTitle("Clientts info");
		   for(Object x:a.AllClients())
		   {Client c=(Client)x;
			   Object[] obj={c.getClientId(),c.getClientName(),c.getClientCardNr(),c.getClientCNP(),c.getClientAddress()};
			   model.addRow(obj);
			   model.fireTableDataChanged();
		   }
                          
		   

		   JScrollPane scrollPane3 = new JScrollPane(clientTable);
		   scrollPane3.setBounds(10, 50, 950, 120);
		    scrollPane3.setEnabled(false);
		    
		    
		   dialog.add(scrollPane3);
		   dialog.pack();
		   dialog.setVisible(true);
		
                
                
}
                         
                          if (e.getSource() == viewempl) {
				Object data[][] ={};
		  model=new DefaultTableModel(data,columnNamesEmpl);
		   employeeTable= new JTable(model);
		   employeeTable.setEnabled(false);
		   JDialog dialog=new JDialog();
		   dialog.setPreferredSize(new Dimension(650,300));
		 
		  
		    dialog.setLocationRelativeTo(null);
		    dialog.setTitle("Employees info");
		   for(Object x:em.AllEmployees())
		   {Employee c=(Employee)x;
			   Object[] obj={c.getEmployeeId(),c.getEmployeeName(),c.getEmployeeAge(),c.getEmployeeDate()};
			   model.addRow(obj);
			   model.fireTableDataChanged();
		   }
                          
		   

		   JScrollPane scrollPane3 = new JScrollPane(employeeTable);
		   scrollPane3.setBounds(10, 50, 950, 120);
		    scrollPane3.setEnabled(false);
		    
		    
		   dialog.add(scrollPane3);
		   dialog.pack();
		   dialog.setVisible(true);
		
                
                
}
                         
                         if (e.getSource() == addclient) {
                             boolean ok=false;
				Integer idcc = Integer.parseInt(idc.getText());
				String namecc = namec.getText();
                                Integer cardnrr = Integer.parseInt(cardnr.getText());
                                 String cnpp = cnp.getText();
                                String addrr = addr.getText();
                                
				Client parsedClient= new Client();
				parsedClient.setClientId(idcc);
				parsedClient.setClientName(namecc);
                                parsedClient.setClientCNP(cnpp);
                                parsedClient.setClientCardNr(cardnrr);
				parsedClient.setClientAddress(addrr);
				operations.addClient(parsedClient);ok=true;
      //if (ok){JOptionPane.showMessageDialog(null, "Clientul a fost adaugat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);}
      //else {JOptionPane.showMessageDialog(null, "Verifica datele introduse! Nu sunt corecte", null, JOptionPane.ERROR_MESSAGE);};
                          //      updateTableClient();
				
				       
} 
                          if (e.getSource() == updateclient) {
				Integer idcc = Integer.parseInt(idc.getText());
				String addrr = addr.getText();
                               
                                
				Client parsedClient= new Client();
				parsedClient.setClientId(idcc);
				parsedClient.setClientAddress(addrr);
				operations.updateClient(parsedClient);
                                 JOptionPane.showMessageDialog(null, "Clientul a fost actualizat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                            //    updateTableClient();
				
				       
} 
  
                           if (e.getSource() == addaccount) {
				Integer idaa = Integer.parseInt(ida.getText());
				String typeaa = typea.getText();
                                Double amountt = Double.parseDouble(amount.getText());
                                 String creatdatee = creatdate.getText();
                                 Integer idcc = Integer.parseInt(idc.getText());
                                 Integer ideptaa = Integer.parseInt(idepta.getText());
                                
                                
				Account parsedAccount= new Account();
				parsedAccount.setAccountId(idaa);
				parsedAccount.setAccountType(typeaa);
                                parsedAccount.setAccountAmount(amountt);
                                parsedAccount.setAccountDate(creatdatee);
				parsedAccount.setClientId(idcc);
                                parsedAccount.setEmployeeId(ideptaa);
				operations.addAccount(parsedAccount);
                                 JOptionPane.showMessageDialog(null, "Contul a fost adaugat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
				
				       
} 
                           if (e.getSource() == updateaccount) {
				Integer idaa = Integer.parseInt(ida.getText());
				String typeaa = typea.getText();
                               
                                
				Account parsedAccount= new Account();
				parsedAccount.setAccountId(idaa);
				parsedAccount.setAccountType(typeaa);
				operations.updateAccount(parsedAccount);
                                 JOptionPane.showMessageDialog(null, "Contul a fost actualizat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                               
				
				       
} 
                   
                           if (e.getSource() == delaccount) {
				Integer idaa = Integer.parseInt(ida.getText());
                                
				operations.deleteAccount(idaa);
                                 JOptionPane.showMessageDialog(null, "Contul a fost sters cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                                
       }
                           
                           
                           
                           
                           
                           
                           
                           
                           if (e.getSource() == addempl) {
				Integer idee = Integer.parseInt(ide.getText());
				String nameee = namee.getText();
                                 Integer agee = Integer.parseInt(age.getText());
                                String empldatee = empldate.getText();
                                
                                
				Employee parsedEmployee= new Employee();
				parsedEmployee.setEmployeeId(idee);
				parsedEmployee.setEmployeeName(nameee);
                                parsedEmployee.setEmployeeAge(agee);
                                parsedEmployee.setEmployeeDate(empldatee);
				
				operations.addEmployee(parsedEmployee);
                                 JOptionPane.showMessageDialog(null, "Employee a fost adaugat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                                
				
				       
} 
                           if (e.getSource() == updateempl) {
				Integer idee = Integer.parseInt(ide.getText());
				String nameee = namee.getText();
                               
                                
				Employee parsedEmployee= new Employee();
				parsedEmployee.setEmployeeId(idee);
				parsedEmployee.setEmployeeName(nameee);
				operations.updateEmployee(parsedEmployee);
                                 JOptionPane.showMessageDialog(null, "Employee a fost actualizat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                               
				
				       
} 
                   
                           if (e.getSource() == delempl) {
				Integer idee = Integer.parseInt(ide.getText());
				operations.deleteEmployee(idee);
                                 JOptionPane.showMessageDialog(null, "Employee a fost sters cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                                
       }
                           
                           
                           
                           if(e.getSource()==transfer)
                           {
                               Integer idaa1=Integer.parseInt(ida.getText());
                               Integer idaa2=Integer.parseInt(ida1.getText());
                               Double sum=Double.parseDouble(sumatransfer.getText());
                               Account parsedAccount1= new Account();
			       parsedAccount1.setAccountId(idaa1);
                                Account parsedAccount2= new Account();
			       parsedAccount2.setAccountId(idaa2);
                               
                               operations.transferintreconturi(parsedAccount1,parsedAccount2,sum);
    
                              
    
        // JOptionPane.showMessageDialog(null, "Valori gresite", "Alert", JOptionPane.ERROR_MESSAGE);
                      
     
	}
                           
                           
                           if(e.getSource()==bills)
                           {
                               Integer idaa=Integer.parseInt(ida.getText());
                               Double suma=Double.parseDouble(sumafactura.getText());
                               Account parsedAccount= new Account();
			       parsedAccount.setAccountId(idaa);
                               operations.procesarefacturaa(parsedAccount,suma);
                              
                           }
                           
                           if(e.getSource()==report)
                           {
                               Integer idee=Integer.parseInt(ide.getText());
                               String data=reportdate.getText();
                               Account parsedAccount= new Account();
			       parsedAccount.setEmployeeId(idee);
                               parsedAccount.setAccountDate(data);
                               operations.report(parsedAccount);
                               //JOptionPane.showMessageDialog(null, "Factura platita cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                           }
}
          }}