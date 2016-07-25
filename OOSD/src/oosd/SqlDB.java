package oosd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlDB {
    String query;
    Connection conn;
    private static String JDBC_DRIVER;
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASS;

    public SqlDB() {
        this.query = null;
        this.conn = null;
        SqlDB.JDBC_DRIVER = "com.mysql.jdbc.Driver";
        SqlDB.DB_URL = "jdbc:mysql://localhost:3306/OOSD?autoReconnect=true&useSSL=false";
        SqlDB.DB_USER = "root";
        SqlDB.DB_PASS = "65108105";
        
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Connecting to database...");

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            if (conn != null) {
                System.out.println("Connected to the database OOSD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Save(Account user) throws SQLException {
        System.out.println("Saving ...");

        query = "insert into Users (Password, FirstName, LastName, Score)"
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

        query = "insert into Movies (Name, Year, Genre, Duration, Director, Description)"
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
