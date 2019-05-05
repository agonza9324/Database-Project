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
public class Truck {
    private String truckID;
    private int milage;
    private int truckSize;
    private String registration;
    private Date serviceDate;

    public Truck(){}
    
    public Truck(String truckID, int milage, int truckSize, String registration, Date serviceDate) {
        this.truckID = truckID;
        this.milage = milage;
        this.truckSize = truckSize;
        this.registration = registration;
        this.serviceDate = serviceDate;
    }

    public String getTruckID() {
        return truckID;
    }

    public int getMilage() {
        return milage;
    }

    public int getTruckSize() {
        return truckSize;
    }

    public String getRegistration() {
        return registration;
    }

    public Date getServiceDate() {
        return serviceDate;
    }
        
}
