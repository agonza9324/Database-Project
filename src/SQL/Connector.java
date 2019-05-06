/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author S
 */
public class Connector {
    static final String userName="jdelar1";//put your MySQL user name
    static final String password="Cosc*bhbj";//put your MySQL password
    private static String driverName = "com.mysql.jdbc.Driver"; 
    private static String url = "jdbc:mysql://triton.towson.edu:3360/jdelar1db"; 
    private static Connection connection=null;
    
     public static Connection getConnection() {
        Object newInstance;
           
        try {
            newInstance = Class.forName(driverName).newInstance();
            try {
                connection = DriverManager.getConnection(url, userName, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        } catch(Exception ex) {
            //I don't want to handle this exception in my code. Fuck Java
            ex.printStackTrace();
        }
        
        return connection;
    }    
}

//       Statement queryStatement = connection.createStatement();
//        updateStaff = null;
//            String querys="select * from *****db.staff;"; //your db 
//            ResultSet results = queryStatement.executeQuery(querys);
//            while(results.next())
//            {
//                System.out.print(results.getString("fName"));
//                System.out.print("    ");
//                System.out.print(results.getString("lName"));
//                System.out.println();
//            }   
//            querys="UPDATE *****db.staff SET salary = 8802 WHERE staffNo = 'SA9';";
//            updateStaff = connection.prepareStatement(querys);
//            updateStaff.executeUpdate();
