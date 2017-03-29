/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Anda
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
{
 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
	           public void run()
	           {
	        	GraphicControl userInterface = new GraphicControl();
	       		userInterface.setVisible(true);
	           }
	       });
	}
  
}
    }
    

