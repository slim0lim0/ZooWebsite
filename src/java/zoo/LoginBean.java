/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zoo;

import java.io.Serializable;

public class LoginBean implements Serializable
{
 
   private String userName, password;
   public int employeeID;
   
   public LoginBean()
   {  
      userName = null;
      password = null;
      employeeID = 0;
      
   }
  
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the ID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param ID the ID to set
     */
    public void setEmployeeID(int ID) {
        this.employeeID = ID;
    }
   
 
}