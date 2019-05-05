package Models;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.Map;

/**
 *
 * @author Direspark
 */
public abstract class Model {
    
    String tableName;
    String[] keys;
    
    public Model(String tableName, String... keys) {
        this.keys = keys;
    }
    
    //return a boolean indicating whether the save operation was successful. 
    //It might make more sense to throw an error. Not sure, a save operation should really always work.
    //This method should perform an update/upsert type operation https://chartio.com/resources/tutorials/how-to-insert-if-row-does-not-exist-upsert-in-mysql/
    //INSERT INTO table_name ... ON DUPLICATE KEY UPDATE
    public boolean Save() {
        //this is the basic syntax to get the db connection via the Connector class.
        //executeQuery returns a resultSet, we can iterate 
        Connection connection = Connector.getConnection();
        Statement stmt = connection.createStatement();
        
        String baseQuery = String.format("REPLACE INTO %s", tableName);
        StringBuilder builder = new StringBuilder(baseQuery);
        
        
        
        stmt.executeQuery();
    }
    
    //find a models based on a dictionary (a dictionary is just like a simple JavaScript object)
    //use the dictionary to construct the WHERE clause.
    //empty dictionary should return the whole table...?
    public Model[] Find(Map<String, String> criteria) {
         Connection connection = Connector.getConnection();//WHERE THE HELL DID MY CODE GO????????
        Statement stmt = connection.createStatement();
        
        String baseQuery = String.format("SELECT * FROM %s WHERE ", tableName);
        StringBuilder builder = new StringBuilder(baseQuery);
        
        boolean multipleCriteria = false;
        for ( Map.Entry<String, String> entry : criteria.entrySet() ) {
            if (multipleCriteria) builder.append(" AND ");
            builder.append(String.format("%s=%s", entry.getKey(), entry.getValue()));
            multipleCriteria = true;
        }
        
        
        stmt.executeQuery(builder.toString());
    }
}
