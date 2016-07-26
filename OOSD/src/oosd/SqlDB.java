package oosd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlDB {
    String query;
    Connection conn;
    private static String JDBC_DRIVER;
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASS;

    Account account;
    Movie movie;
    
    public SqlDB() {
        this.query = null;
        this.conn = null;
        SqlDB.JDBC_DRIVER = "com.mysql.jdbc.Driver";
        SqlDB.DB_URL = "jdbc:mysql://localhost:3306/OOSD?autoReconnect=true&useSSL=false";
        SqlDB.DB_USER = "root";
        SqlDB.DB_PASS = "65108105";
        
        account = new Account();
        movie = new Movie();
        
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

    public Account ReadAccount(int Id) throws SQLException {
        System.out.println("Loading ...");

        query = "select * from Users where id = ?";
        
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, Id);
        ResultSet rs = preparedStmt.executeQuery();
        
        while (rs.next())
        {
            account.setId(Id);
            account.setFirstName(rs.getString("FirstName"));
            account.setLastName(rs.getString("LastName"));
            account.setScore(rs.getInt("Score"));
            account.setPassword(rs.getString("Password"));
        }
        
        return account;
    }
    
    public Movie ReadMovie(int Id) throws SQLException {
        System.out.println("Loading ...");

        query = "select * from Movies where id = ?";
        
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, Id);
        ResultSet rs = preparedStmt.executeQuery();
        
        while (rs.next())
        {
            movie.setId(Id);
            movie.setName(rs.getString("Name"));
            movie.setDirector(rs.getString("Director"));
            movie.setYear(rs.getInt("Year"));
            movie.setDescription(rs.getString("Description"));
            movie.setDuration(rs.getInt("Duration"));
            
            String comma = ",";
            String allGenres = rs.getString("Genre");
            List<String> Genre = new ArrayList<>();
            String []Gnr = allGenres.split(comma);
            
            Genre.addAll(Arrays.asList(Gnr));
            movie.setGenre(Genre);
        }
        
        return movie;
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
            comma = ",";
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
