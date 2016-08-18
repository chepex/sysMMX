/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;
 
 
 
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
 

 

/**
 *
 * @author mmixco
 */

@ManagedBean(name="loginBean")
@Stateless
public class LoginBean  implements Serializable {

    
   
    
    
    public LoginBean() {
        
        
    }

     
    public String ssuser (){	      
        String user ="MMIXCO";	      
       

      return user ;	


    }
          
	 
    
            
}
