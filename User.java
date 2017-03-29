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
public class User {
     private String userusername;
    private String userpassword;
    
      public String getUserUsername()
        {
            return userusername;
            
        }
        
    public void setUserUsername(String user)
    {
        this.userusername=user;
    }
    
       public String getUserPassword()
        {
            return userpassword;
            
        }
        
    public void setUserPassword(String pass)
    {
        this.userpassword=pass;
    }
}
