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
public class StorageUnit {
    private int unitNumber;
    private String location;
    private int rate;
    private String size;
    private String clientID;
    
    public StorageUnit(){}

    public StorageUnit(int unitNumber, String location, int rate, String size, String clientID) {
        this.unitNumber = unitNumber;
        this.location = location;
        this.rate = rate;
        this.size = size;
        this.clientID = clientID;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public String getLocation() {
        return location;
    }

    public int getRate() {
        return rate;
    }

    public String getSize() {
        return size;
    }

    public String getClientID() {
        return clientID;
    }   
}
