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
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String str = null;

    public Movie Read(String Name) {
        System.out.println("Loading ...");
        
        Movie movie = new Movie();
        str = "database/movies.json";
        try (Reader reader = new FileReader(str)) {
            movie = gson.fromJson(reader, Movie.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return movie;
    }
    
    public Account Read(int Id) {
        System.out.println("Loading ...");
        
        Account user = new Account();
        str = "database/users.json";
        try (Reader reader = new FileReader(str)) {
            user = gson.fromJson(reader, Account.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public void Save(Account user) {
        System.out.println("Saving ...");
        
        String json = gson.toJson(user);
        System.out.println(json);
        str = "database/users.json";
        try(FileWriter writer = new FileWriter(str, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw)) {
            gson.toJson(user, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Saved Seccessfully");
    }
    
    public void Save(Movie movie) {
        System.out.println("Saving ...");
        
        String json = gson.toJson(movie);
        System.out.println(json);
        str = "database/movies.json";
        try(FileWriter writer = new FileWriter(str, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw)) {
            gson.toJson(movie, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Saved Seccessfully");
    }
}
