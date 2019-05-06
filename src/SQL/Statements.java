/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Direspark
 */
public class Statements {
    public final static String GET_EMPLOYEES = "SELECT * FROM jdelar1db.Employee;";
    public final static String GET_TRUCKS = "SELECT * FROM jdelar1db.Truck;";    
    public final static String GET_JOBS = "SELECT * FROM jdelar1db.Job;";    
    public final static String GET_CLIENTS = "SELECT * FROM jdelar1db.Client;";
    public final static String GET_STORAGE = "SELECT * FROM jdelar1db.StorageUnit;";
    public final static String GET_JOBEMPS = "SELECT * FROM jdelar1db.JobEmps;";
    public final static String GET_JOBTRUCKS = "SELECT * FROM jdelar1db.JobTrucks;";
    public final static String GET_SCHEDULE = 
            "SELECT jobDate, fName, lName, truckCount, empCount, services\n" +
            "FROM (SELECT jobID, count(*)empCount\n" +
            "	FROM jdelar1db.JobEmps\n" +
            "	GROUP BY jobID) AS emps\n" +
            "	JOIN\n" +
            "	(SELECT jobs.jobID, jobDate, fName, lName, services, truckCount  \n" +
            "		FROM (SELECT jobID, count(*)truckCount \n" +
            "			FROM jdelar1db.JobTrucks\n" +
            "			GROUP BY jobID)AS trucks\n" +
            "		JOIN\n" +
            "		(SELECT jobID, jobDate, fName, lName, services\n" +
            "		FROM jdelar1db.Job, jdelar1db.Client\n" +
            "		WHERE jdelar1db.Job.clientID = jdelar1db.Client.clientID) AS jobs\n" +
            "	WHERE trucks.jobID = jobs.jobID) AS sched\n" +
            "WHERE sched.jobID = emps.jobID\n"
            + "ORDER BY jobDate DESC;";
    
     public static String AddEmployee(String employeeId, String fname, String lname, String dob) {
        String columns = "(`employeeID`, `fName`, `lName`, `DOB`)";
        String values = String.format("(\'%s\', \'%s\', \'%s\', \'%s\')", employeeId, fname, lname, dob.toString());
        String query = "INSERT INTO `jdelar1db`.`Employee` %s VALUES %s;";
        
        return String.format(query, columns, values);
    }
        
    public static String DeleteEmployee(String employeeId) {
        String query = "DELETE FROM `jdelar1db`.`Employee` where (`employeeID`=\'%s\');";
        return String.format(query, employeeId);
    }
    public static String AddTruck(String truckId, String mileage, String truckSize, String registration, String serviceDate) {
        String columns = "(`truckId`, `mileage`, `truckSize`, `registration`, `serviceDate`)";
        String values = String.format("(\'%s\', \'%s\', \'%s\', \'%s\', \'%s\')", truckId, mileage, truckSize, registration, serviceDate.toString());
        String query = "INSERT INTO jdelar1db.Truck %s VALUES %s;";
        
        return String.format(query, columns, values);
    }
        
    public static String DeleteTruck(String truckId) {
        String query = "DELETE FROM `jdelar1db`.`Truck` where (`truckID`=\'%s\');";
        return String.format(query, truckId);
    }
    public static String AddJob(String jobId, String fromLoc, String toLoc, String tot_hours, String estCost, String jobDate,
        String clientID, String service) {
        String columns = "(jobId, fromLoc, toLoc, tot_hours, estCost, jobDate, clientID, services)";
        String values = String.format("(\'%s\', \'%s\', \'%s\', %s, %s, \'%s\', \'%s\', \'%s\')", jobId, 
                fromLoc, toLoc, tot_hours, estCost, jobDate, clientID, service);
        String query = "INSERT INTO jdelar1db.Job %s VALUES %s;";
        
        return String.format(query, columns, values);
    }
        
    public static String DeleteJob(String jobId) {
        String query = "DELETE FROM `jdelar1db`.`Job` WHERE `jobID`=\'%s\'";
        return String.format(query, jobId);
    }
    
     public static String AddClient(String clientID, String fName, String lName, String phone) {
        
        String columns = "(clientID, fName, lName, phone)";
        String values = String.format("(\'%s\', \'%s\', \'%s\', \'%s\')", clientID, fName, lName, phone);
        String query = "INSERT INTO jdelar1db.Client %s VALUES %s;";
        
        return String.format(query, columns, values);
    }
     
     public static String DeleteClient(String clientId) {
        String query = "DELETE FROM `jdelar1db`.`Client` WHERE `clientID`=\'%s\'";
        return String.format(query, clientId);
    }
     
     public static String AddStorage(String unitNumber, String location, String rate, String size, String clientID) {
        
        String columns = "(unitNumber, location, rate, size, clientID)";
        String values = String.format("(%s, \'%s\', \'%s\', \'%s\', \'%s\')", unitNumber, location, rate, size, clientID);
        String query = "INSERT INTO jdelar1db.StorageUnit %s VALUES %s;";
        
        return String.format(query, columns, values);
    }
     
     public static String DeleteStorage(String unitNumber) {
        String query = "DELETE FROM `jdelar1db`.`StorageUnit` WHERE `unitNumber`=\'%s\'";
        return String.format(query, unitNumber);
    }
     public static String AddJobEmps( String jobID, String empID) {
        
        String columns = "(jobID, employeeID)";
        String values = String.format("(\'%s\', \'%s\')", jobID, empID);
        String query = "INSERT INTO jdelar1db.JobEmps %s VALUES %s;";
        
        return String.format(query, columns, values);
    }
     
     public static String DeleteJobEmps(String jobId, String empID) {
        String query = "DELETE FROM `jdelar1db`.`JobEmps` WHERE `employeeID`=\'%s\'\n"
                + "AND `jobID`=\'%s\'";
        return String.format(query, empID, jobId);
    }
     public static String AddJobTrucks(String jobID, String truckID) {
        
        String columns = "(jobID, truckID)";
        String values = String.format("(\'%s\', \'%s\')", jobID, truckID);
        String query = "INSERT INTO jdelar1db.JobTrucks %s VALUES %s;";
        
        return String.format(query, columns, values);
    }
     
     public static String DeleteJobTrucks(String truckID) {
        String query = "DELETE FROM `jdelar1db`.`JobTrucks` WHERE `truckID`=\'%s\'";
        return String.format(query, truckID);
    }
}
