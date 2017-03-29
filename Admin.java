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
public class Admin {
    private String adminusername;
    private String adminpassword;
    
      public String getAdminUsername()
        {
            return adminusername;
            
        }
        
    public void setAdminUsername(String user)
    {
        this.adminusername=user;
    }
    
       public String getAdminPassword()
        {
            return adminpassword;
            
        }
        
    public void setAdminPassword(String pass)
    {
        this.adminpassword=pass;
    }
}
