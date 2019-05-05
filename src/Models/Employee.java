/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Direspark
 */
public class Employee{
    private String Job;
    private String fName;
    private String lName;
    private Date DOB;
    
    
    public Employee(){}
    
    public Employee(String employeeID, String fName,String lName, Date DOB){
        this.Job = employeeID;
        this.fName = fName;
        this.lName = lName;
        this.DOB = DOB;
    }
    
    public String getJob(){
        return this.Job;
    }
    
    public String getFName(){
        return this.fName;
    }
    
       public String getLname(){
        return this.lName;
    }
       
     public Date getDOB(){
        return this.DOB;
    }
}
