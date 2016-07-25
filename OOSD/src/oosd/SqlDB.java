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
        
        String query = "insert into Users (Password, FirstName, LastName, Score)"
        + " values (?, ?, ?, ?)";
        
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, user.getPassword());
        preparedStmt.setString (2, user.getFirstName());
        preparedStmt.setString (3, user.getLastName());
        preparedStmt.setInt(4, user.getScore());
      
        preparedStmt.execute();
    }
    
    public void Save(Movie movie) throws SQLException {
        System.out.println("Saving ...");

        String comma="";
        StringBuilder allGenres = new StringBuilder();
        for (String g: movie.getGenre()) {
            allGenres.append(comma);
            allGenres.append(g);
            comma = ", ";
        }
        
        String query = "insert into Movies (Name, Year, Genre, Duration, Director, Description)"
        + " values (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, movie.getName());
        preparedStmt.setInt(2, movie.getYear());
        preparedStmt.setString(3, allGenres.toString());
        preparedStmt.setInt(4, movie.getDuration());
        preparedStmt.setString (5, movie.getDirector());
        preparedStmt.setString (6, movie.getDescription());
      
        preparedStmt.execute();
    }
}
