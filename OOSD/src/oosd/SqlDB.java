package oosd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlDB {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/OOSD";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "65108105";
    
    Connection conn = null;
   
    public SqlDB() {
        
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Connecting to database...");
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            if (conn != null) {
                System.out.println("Connected to the database test1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Save(Account user) throws SQLException {
        System.out.println("Saving ...");
        
        String query = "insert into users (FirstName, LastName, Score)"
        + " values (?, ?, ?)";
        
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, user.getFirstName());
        preparedStmt.setString (2, user.getLastName());
        preparedStmt.setInt(3, user.getScore());
      
        preparedStmt.execute();
    }
}
