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
        List<Movie> movies = new ArrayList<Movie>();

        try {
            movies = (List<Movie>) sql.ReadAllMovies();
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movies;
    }

    public Object ImportMovies() {
        List<Movie> movies = new ArrayList<Movie>();

        movies = (List<Movie>) json.ImportMovie();

        return movies;
    }

    public Object Search(Movie movie) {
        List<Movie> movies = new ArrayList<Movie>();

        try {
            movies = (List<Movie>) sql.Search(movie);
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movies;
    }

    public void Edit(Movie movie) {
        try {
            sql.Edit(movie);
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Save(Movie movie) {
        json.Save(movie);

        try {
            sql.Save(movie);
        } catch (SQLException ex) {
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Save(Account account) {
        json.Save(account);

        try {
            sql.Save(account);
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
