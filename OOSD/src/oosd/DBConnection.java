package oosd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/OOSD";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "65108105";
    
    Connection conn = null;
   
    public DBConnection() {
        
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Connecting to database...");
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            if (conn != null) {
                System.out.println("Connected to the database test1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void test() {
        
        String query = "insert into Users (Id, FirstName, LastName)" + "values (?, ?, ?)";
        
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(query);
            
            statement.setString(1, "1");
            statement.setString(2, "Ali");
            statement.setString(3, "Torabi");
            
            statement.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
