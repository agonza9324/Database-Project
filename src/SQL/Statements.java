package SQL;

import java.sql.Date;

/**
 *
 * @author Direspark
 */
public class Statements {
    public final static String GET_EMPLOYEES = "SELECT * FROM jdelar1db.Employee;";
    public final static String GET_TRUCKS = "SELECT * FROM jdelar1db.Truck;";
    
    
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
        String columns = "(`mileage`, `truckSize`, `registration`, `serviceDate`)";
        String values = String.format("(\'%s\', \'%s\', \'%s\', \'%s\', \'%s\')", truckId, mileage, truckSize, registration, serviceDate.toString());
        String query = "INSERT INTO jdelar1db.Employee %s VALUES %s;";
        
        return String.format(query, columns, values);
    }
        
    public static String DeleteTruck(String truckId) {
        String query = "DELETE FROM `jdelar1db`.`Truck` where (`truckID`=\'%s\');";
        return String.format(query, truckId);
    }
}
