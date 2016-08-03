package oosd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ali
 */
public class JsonDB {

    private final Gson gson;
    private String addr;

    /**
     *
     */
    public JsonDB() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.addr = null;
    }

    /**
     *
     * @param Id
     * @return
     */
    public Movie ReadMovie(int Id) {
        System.out.println("Loading ...");

        Movie movie = new Movie();
        addr = "database/movies.json";

        try {
            JsonReader reader = new JsonReader(new FileReader(addr));
            movie = gson.fromJson(reader, Movie.class);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movie;
    }

    /**
     *
     * @return
     */
    public Object ImportMovie() {
        System.out.println("Loading Movies From Json ...");

        List<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie();
        addr = "database/import.json";

        try {
            JsonReader reader = new JsonReader(new FileReader(addr));
            movie = gson.fromJson(reader, Movie.class);
            movies.add(movie);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movies;
    }

    /**
     *
     * @param Id
     * @return
     */
    public Account ReadAccount(int Id) {
        System.out.println("Loading ...");

        Account account = new Account();
        addr = "database/users.json";

        try {
            JsonReader reader = new JsonReader(new FileReader(addr));
            account = gson.fromJson(reader, Account.class);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return account;
    }

    /**
     *
     * @param user
     */
    public void Save(Account user) {
        System.out.println("Saving ...");

        String json = gson.toJson(user);
        addr = "database/users.json";
        try (FileWriter writer = new FileWriter(addr, true);
                BufferedWriter bw = new BufferedWriter(writer);
                PrintWriter out = new PrintWriter(bw)) {
            gson.toJson(user, writer);
            System.out.println("Saved Seccessfully");
        } catch (IOException e) {
            System.out.println("We couldn't save data to Json :(");
        }
    }

    /**
     *
     * @param movie
     */
    public void Save(Movie movie) {
        System.out.println("Saving ...");

        String json = gson.toJson(movie);
        addr = "database/movies.json";
        try (FileWriter writer = new FileWriter(addr, true);
                BufferedWriter bw = new BufferedWriter(writer);
                PrintWriter out = new PrintWriter(bw)) {
            gson.toJson(movie, writer);
            System.out.println("Saved Seccessfully");
        } catch (IOException e) {
            System.out.println("We couldn't save data to Json :(");
        }
    }
}
