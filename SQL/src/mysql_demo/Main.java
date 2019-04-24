package mysql_demo;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
      try {
        Connector.createDBConnection();
      } catch(Exception ex) {
        System.out.println("Error setting up database connection. Exiting.");
        ex.printStackTrace();
        System.exit(-1);
      }

      Connection conn = Connector.getConnection();

      //Example usage, log all users in database
      //users def: fname VARCHAR(20), lname VARCHAR(20), email varchar(100)
      try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        while (rs.next()) {
          String fname = rs.getString("fname");
          String lname = rs.getString("lname");
          String email = rs.getString("email");

          System.out.printf("First Name: %s\nLastName: %s\nEmail: %s\n", fname, lname, email);
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }

    }
    
}
