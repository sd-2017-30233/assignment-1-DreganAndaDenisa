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
public class Client {
    
    
    private Integer idc;
	private String namec;
        private Integer card_number;
        private String cnp;
        private String address;
         //private DatabaseConnectionController conn=new DatabaseConnectionController();
	
	public Integer getClientId() {
		return idc;
	}
	public void setClientId(Integer idc) {
		this.idc = idc;
	}
	public String getClientName() {
		return namec;
	}
	public void setClientName(String namec) {
		this.namec = namec;
	}  
        
        public Integer getClientCardNr() {
		return card_number;
	}
	public void setClientCardNr(Integer card_number) {
		this.card_number = card_number;
	}
        
        public String getClientCNP() {
		return cnp;
	}
	public void setClientCNP(String cnp) {
		this.cnp = cnp;
	}  
        
        public String getClientAddress() {
		return address;
	}
	public void setClientAddress(String address) {
		this.address = address;
	}  
        
}
