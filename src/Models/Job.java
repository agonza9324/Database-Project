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
public class Job{
    private String jobID;
    private String fromLoc;
    private String toLoc;
    private int tot_hours;
    private double estCost;
    private Date jobDate;
    private String clientID;
    private String services;
    
    public Job(){}
    
    public Job(String jobID, String fromLoc, String toLoc, int tot_hours,
            double estCost, Date jobDate, String clientID, String services ){
        this.jobID = jobID;
        this.fromLoc = fromLoc;
        this.toLoc = toLoc;
        this.tot_hours = tot_hours;
        this.estCost = estCost;
        this.jobDate = jobDate;
        this.clientID = clientID;
        this.services = services;
    }
    
    public String getJobID(){
        return this.jobID;
    }
    
    public String getfromLoc(){
        return this.fromLoc;
    }
    
    public String toLoc(){
        return this.toLoc;
    }
       
     public Date getJobDate(){
        return this.jobDate;
    }

    public String getFromLoc() {
        return fromLoc;
    }

    public String getToLoc() {
        return toLoc;
    }

    public int getTot_hours() {
        return tot_hours;
    }

    public double getEstCost() {
        return estCost;
    }

    public String getClientID() {
        return clientID;
    }

    public String getServices() {
        return services;
    }
}
