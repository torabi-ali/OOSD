package oosd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlDB {

    private static String JDBC_DRIVER;
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASS;
    String query;
    Connection conn;

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

        while (rs.next()) {
            account.setId(Id);
            account.setFirstName(rs.getString("FirstName"));
            account.setLastName(rs.getString("LastName"));
            account.setScore(rs.getInt("Score"));
            account.setPassword(rs.getString("Password"));
        }

        return account;
    }

    public Object ReadAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<Movie>();

        query = "select * from Movies";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        ResultSet rs = preparedStmt.executeQuery();

        while (rs.next()) {
            movie = new Movie();
            movie.setId(rs.getInt("Id"));
            movie.setName(rs.getString("Name"));
            movie.setDirector(rs.getString("Director"));
            movie.setYear(rs.getInt("Year"));
            movie.setDescription(rs.getString("Description"));
            movie.setDuration(rs.getInt("Duration"));

            String comma = ",";
            String allGenres = rs.getString("Genre");
            List<String> Genre = new ArrayList<>();
            String[] Gnr = allGenres.split(comma);

            Genre.addAll(Arrays.asList(Gnr));
            movie.setGenre(Genre);

            movies.add(movie);
        }

        return movies;
    }

    public Movie ReadMovie(int Id) throws SQLException {
        System.out.println("Loading ...");

        query = "select * from Movies where id = ?";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, Id);
        ResultSet rs = preparedStmt.executeQuery();

        while (rs.next()) {
            movie.setId(Id);
            movie.setName(rs.getString("Name"));
            movie.setDirector(rs.getString("Director"));
            movie.setYear(rs.getInt("Year"));
            movie.setDescription(rs.getString("Description"));
            movie.setDuration(rs.getInt("Duration"));

            String comma = ",";
            String allGenres = rs.getString("Genre");
            List<String> Genre = new ArrayList<>();
            String[] Gnr = allGenres.split(comma);

            Genre.addAll(Arrays.asList(Gnr));
            movie.setGenre(Genre);
        }

        return movie;
    }

    public Object Search(Movie movie) throws SQLException {
        List<Movie> movies = new ArrayList<Movie>();
        int counter = 0;
        System.out.println("Saving ...");

        String comma = "";
        StringBuilder allGenres = new StringBuilder();
        if (movie.getGenre() == null) {
            allGenres = null;
        } else {
            for (String g : movie.getGenre()) {
                allGenres.append(comma);
                allGenres.append(g);
                comma = ",";
            }
        }

        query = "select * from Movies where ";

        if (movie.getName() != null) {
            query += "Name = " + '\'' + movie.getName() + '\'';
            counter++;
        }
        if (movie.getDirector() != null) {
            if (counter != 0) {
                query += " and ";
                counter--;
            }
            query += "Director = " + '\'' + movie.getDirector() + '\'';
            counter++;
        }
        if (movie.getYear() != 0) {
            if (counter != 0) {
                query += " and ";
                counter--;
            }
            query += "Year = " + movie.getYear();
            counter++;
        }
        if (allGenres != null) {
            if (counter != 0) {
                query += " and ";
                counter--;
            }
            query += "Genre = " + allGenres;
            counter++;
        }
        if (movie.getDuration() != 0) {
            if (counter != 0) {
                query += " and ";
                counter--;
            }
            query += "Duration = " + movie.getDuration();
            counter++;
        }

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            movie = new Movie();
            movie.setId(rs.getInt("Id"));
            movie.setName(rs.getString("Name"));
            movie.setDirector(rs.getString("Director"));
            movie.setYear(rs.getInt("Year"));
            movie.setDescription(rs.getString("Description"));
            movie.setDuration(rs.getInt("Duration"));

            comma = ",";
            String Search_Genres = rs.getString("Genre");
            List<String> Genre = new ArrayList<>();
            String[] Gnr = Search_Genres.split(comma);

            Genre.addAll(Arrays.asList(Gnr));
            movie.setGenre(Genre);

            movies.add(movie);
        }

        return movies;
    }

    public void Edit(Movie movie) {
        System.out.println("Saving ...");

        String comma = "";
        StringBuilder allGenres = new StringBuilder();
        for (String g : movie.getGenre()) {
            allGenres.append(comma);
            allGenres.append(g);
            comma = ",";
        }

        query = "update Movies set Name = ?, Year = ?, Genre = ?, Duration = ?, "
                + "Director = ?, Description = ? where id = ?";

        PreparedStatement preparedStmt;
        try {
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, movie.getName());
            preparedStmt.setInt(2, movie.getYear());
            preparedStmt.setString(3, allGenres.toString());
            preparedStmt.setInt(4, movie.getDuration());
            preparedStmt.setString(5, movie.getDirector());
            preparedStmt.setString(6, movie.getDescription());
            preparedStmt.setInt(7, movie.getId());

            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Edit(Account account) {
        System.out.println("Saving ...");

        query = "update Account set Id = ?, FirstName = ?, LastName = ?, Password = ?, "
                + "Score = ?, Role = ?";

        PreparedStatement preparedStmt;
        try {
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, account.getId());
            preparedStmt.setString(2, account.getLastName());
            preparedStmt.setString(3, account.getPassword());
            preparedStmt.setInt(4, account.getScore());
            preparedStmt.setInt(5, account.getRoleId());

            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Save(Account user) {
        System.out.println("Saving ...");

        query = "insert into Users (Password, FirstName, LastName, Score, Role)"
                + " values (?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt;
        try {
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, user.getPassword());
            preparedStmt.setString(2, user.getFirstName());
            preparedStmt.setString(3, user.getLastName());
            preparedStmt.setInt(4, user.getScore());
            preparedStmt.setInt(5, user.getRoleId());

            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Save(Movie movie) {
        System.out.println("Saving ...");

        String comma = "";
        StringBuilder allGenres = new StringBuilder();
        for (String g : movie.getGenre()) {
            allGenres.append(comma);
            allGenres.append(g);
            comma = ",";
        }

        query = "insert into Movies (Name, Year, Genre, Duration, Director, Description)"
                + " values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt;
        try {
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, movie.getName());
            preparedStmt.setInt(2, movie.getYear());
            preparedStmt.setString(3, allGenres.toString());
            preparedStmt.setInt(4, movie.getDuration());
            preparedStmt.setString(5, movie.getDirector());
            preparedStmt.setString(6, movie.getDescription());

            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getRole() throws SQLException {
        List<String> Role = new ArrayList<String>();

        query = "Select Role From UserRole";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Role.add(rs.getNString("Role"));
        }

        return Role;
    }
}
