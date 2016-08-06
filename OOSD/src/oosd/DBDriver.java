package oosd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBDriver {

    JsonDB json;
    SqlDB sql;
    Account account;
    Movie movie;

    public DBDriver() {
        this.json = new JsonDB();
        this.sql = new SqlDB();
    }

    public Account ReadAccount(int Id) {
// Using Json Database
//        account = json.ReadAccount(Id);

// Using MySQL
        try {
            account = sql.ReadAccount(Id);
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return account;
    }

    public Movie ReadMovie(int Id) {
// Using Json Database
//        movie = json.ReadMovie(Id);

// Using MySQL
        try {
            movie = sql.ReadMovie(Id);
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movie;
    }

    public Object ReadAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try {
            movies = (List<Movie>) sql.ReadAllMovies();
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movies;
    }

    public Object ImportMovies() {

        return (List<Movie>) json.ImportMovie();
    }

    public Object Search(Movie movie) {
        List<Movie> movies = new ArrayList<>();

        try {
            movies = (List<Movie>) sql.Search(movie);
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movies;
    }

    public void Edit(Movie movie) {
        sql.Edit(movie);
    }

    public void Save(Movie movie) {
        json.Save(movie);

        sql.Save(movie);
    }

    public void Save(Account account) {
        json.Save(account);

        sql.Save(account);
    }

    public List<String> GetRole() {
        try {
            return sql.getRole();
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("oosd.DBDriver.GetRole()");
        return null;
    }
}
