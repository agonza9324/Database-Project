/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


/**
 *
 * @author Direspark
 */
public class Client{
    private String clientID;
    private String fName;
    private String lName;
    private String phone;
    
    
    public Client(){}
    
    public Client(String clientID, String fName,String lName, String phone){
        this.clientID = clientID;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
    }
    
    public String getClientID(){
        return this.clientID;
    }
    
    public String getFName(){
        return this.fName;
    }
    
       public String getLname(){
        return this.lName;
    }
       
     public String getPhone(){
        return this.phone;
    }
}
