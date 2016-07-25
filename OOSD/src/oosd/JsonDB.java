package oosd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class JsonDB {
    private final Gson gson;
    private String addr;
    
    public JsonDB() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.addr = null;
    }

    public Movie Read(String Name) {
        System.out.println("Loading ...");
        
        Movie movie = new Movie();
        addr = "database/movies.json";
        try (Reader reader = new FileReader(addr)) {
            movie = gson.fromJson(reader, Movie.class);
        } catch (IOException e) {
            System.out.println("We couldn't read data from Json :(");
        }
        
        return movie;
    }
    
    public Account Read(int Id) {
        System.out.println("Loading ...");
        
        Account user = new Account();
        addr = "database/users.json";
        try (Reader reader = new FileReader(addr)) {
            user = gson.fromJson(reader, Account.class);
        } catch (IOException e) {
            System.out.println("We couldn't read data from Json :(");
        }
        
        return user;
    }
    
    public void Save(Account user) {
        System.out.println("Saving ...");
        
        String json = gson.toJson(user);
        addr = "database/users.json";
        try(FileWriter writer = new FileWriter(addr, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw)) {
            gson.toJson(user, writer);
            System.out.println("Saved Seccessfully");
        } catch (IOException e) {
            System.out.println("We couldn't save data to Json :(");
        }
    }
    
    public void Save(Movie movie) {
        System.out.println("Saving ...");
        
        String json = gson.toJson(movie);
        addr = "database/movies.json";
        try(FileWriter writer = new FileWriter(addr, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw)) {
            gson.toJson(movie, writer);
            System.out.println("Saved Seccessfully");
        } catch (IOException e) {
            System.out.println("We couldn't save data to Json :(");
        }
    }
}
