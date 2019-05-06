/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import SQL.Connector;
import SQL.Statements;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Direspark
 */
public class TableUtils {
    public static void PopulateTableFromStatement(JTable table, String statement) {
        try {
            DefaultTableModel dm = (DefaultTableModel) table.getModel();
            int rowCount = dm.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }
            
            
            Connection connection = Connector.getConnection();
            Statement queryStatement = connection.createStatement();
            
            ResultSet results = queryStatement.executeQuery(statement);
            ResultSetMetaData rsmd = results.getMetaData();
            
            int columnCount = rsmd.getColumnCount();
            String[] columnNames = new String[columnCount];
            for(int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnLabel(i);
            }
            
            while(results.next())
            {
                String[] row = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = results.getString(columnNames[i]);
                }
                
                dm.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Error updating Employees table.");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
