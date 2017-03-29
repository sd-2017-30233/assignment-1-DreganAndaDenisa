/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.Date;

/**
 *
 * @author Anda
 */
public class Account {
    
    private Integer ida;
    private String typea;
    private Double amount;
    private String creat_date;
    private Integer ide;
    private Integer idc;
    
    public Integer getAccountId() {
		return ida;
	}
	public void setAccountId(Integer ida) {
		this.ida= ida;
	}
        
       public String getAccountType() {
		return typea;
	}
       
	public void setAccountType(String typea) {
		this.typea= typea;
	}
        
         public Double getAccountAmount() {
		return amount;
	}
	public void setAccountAmount(Double amount) {
		this.amount= amount;
	}
        
        
        public String getAccountDate() {
		return creat_date;
	}
       
	public void setAccountDate(String creat_date) {
		this.creat_date= creat_date;
	}
        
        
        public Integer getEmployeeId() {
		return ide;
	}
	public void setEmployeeId(Integer ide) {
		this.ide= ide;
	}
    
       public Integer getClientId() {
		return idc;
	}
	public void setClientId(Integer idc) {
		this.idc= idc;
	}
    
    
        public void adaugare(Double sum)
        {
           this.amount=this.amount+sum;
        }
        
        public void retragere(Double sum)
        {
            this.amount=this.amount-sum;
        }
        
}
