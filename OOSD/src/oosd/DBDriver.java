package oosd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ali
 */
public class DBDriver {

    JsonDB json;
    SqlDB sql;
    Account account;
    Movie movie;

    /**
     * Constructor
     */
    public DBDriver() {
        this.json = new JsonDB();
        this.sql = new SqlDB();
    }

    /**
     *
     * @param Id
     * @return
     */
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

    /**
     *
     * @param Id
     * @return
     */
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

    /**
     *
     * @return
     */
    public Object ReadAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try {
            movies = (List<Movie>) sql.ReadAllMovies();
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movies;
    }

    /**
     *
     * @return
     */
    public Object ImportMovies() {

        return (List<Movie>) json.ImportMovie();
    }

    /**
     *
     * @param movie
     * @return
     */
    public Object Search(Movie movie) {
        List<Movie> movies = new ArrayList<>();

        try {
            movies = (List<Movie>) sql.Search(movie);
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movies;
    }

    /**
     *
     * @param movie
     */
    public void Edit(Movie movie) {
        sql.Edit(movie);
    }

    /**
     *
     * @param account
     */
    public void Edit(Account account) {
        sql.Edit(account);
    }

    /**
     *
     * @param movie
     */
    public void Save(Movie movie) {
        json.Save(movie);

        sql.Save(movie);
    }

    /**
     *
     * @param account
     */
    public void Save(Account account) {
        json.Save(account);

        sql.Save(account);
    }

    /**
     *
     * @return
     */
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
