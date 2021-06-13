package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
* Controls basic connection and access to a student database.
* @author Allie Bacholl
*/
public class DatabaseConnection {   
    
    // ******************************
    // Fields
    // ******************************
    /* Holds the current SQLite database connection. */
    private static Connection con = null;
    /* Holds a precompiled SQL statement. */
    private static PreparedStatement prepStmt = null;
    /* Holds the location of the currently connected database. */
    private static String dbLocation;
	
    // ******************************
    // Public Methods
    // ******************************
    /**
     *  Establishes a connection to a student database based on the file location listed in the file dbLocation.txt.
     */
    public static void refreshConnection() { 
        FileReader fr = null;
        String dbLocationFile = ".\\src\\Database\\dbLocation.txt";
        dbLocation = "";
        
        try {
            Class.forName("org.sqlite.JDBC"); 
            fr = new FileReader(dbLocationFile);
 
            /* Ensures connection to database closed to prevent a locked database. */
            if (con != null) {
                con.close();
            }  
            
            int i;
            while ((i=fr.read()) != -1) {
                dbLocation += (char) i;
            }
            
            if (!(new File(dbLocation).exists())) {
                JOptionPane.showMessageDialog(null, "Database missing or deleted. Opening default students database.\nPlease set the location to an existing database.");
                dbLocation = ".\\students.db";
                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(dbLocationFile))) {
                    writer.write(dbLocation);
                }
            } 
            
            con = DriverManager.getConnection("jdbc:sqlite:" + dbLocation);
      
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
		/* Ensure that any running prepared statements and file readers are closed to improve efficiency. */
        finally {
            try { if (fr != null) fr.close(); } catch (Exception e) {};
            try { if (prepStmt != null) prepStmt.close(); } catch (Exception e) {};
        }
    }
    
    /**
     * Creates a prepared statement from the specified SQL string.
     * @param sql The SQL statement to prepare
     * @return The prepared SQL statement
     */
    public static PreparedStatement createPreparedStatement(String sql) {
        try {
            prepStmt = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prepStmt;
    }
    
    /**
     * Gets the location of the database that the application is currently connected to.
     * @return The location of the current database
     */
    public static String getDBLocation() {
        return dbLocation;
    }
}
