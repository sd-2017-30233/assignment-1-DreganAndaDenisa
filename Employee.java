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
public class Employee {
    private Integer ide;
    private String namee;
    private Integer age;
    private String empl_date;
    
    public Integer getEmployeeId() {
		return ide;
	}
	public void setEmployeeId(Integer ide) {
		this.ide = ide;
	}
        
        
        public String getEmployeeName()
        {
            return namee;
            
        }
        
    public void setEmployeeName(String namee)
    {
        this.namee=namee;
    }
        
        
        public Integer getEmployeeAge() {
		return age;
	}
	public void setEmployeeAge(Integer age) {
		this.age = age;
	}
        
        public String getEmployeeDate() {
		return empl_date;
	}
       
	public void setEmployeeDate(String empl_date) {
		this.empl_date=empl_date;
	}
}
