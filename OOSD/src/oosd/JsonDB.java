package oosd;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonDB {
    private final Gson gson = new Gson();
    private String str = null;

    public Movie ReadMovie(String Name) {
        Movie movie = new Movie();
        str = "database/movies/"+ Name+ ".json";
        try (Reader reader = new FileReader(str)) {
            movie = gson.fromJson(reader, Movie.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movie;
    }
    
    public void SaveMovie(Movie movie) {
        System.out.println("Hi");
        System.out.println(movie);
        String json = gson.toJson(movie);
        System.out.println("Hi");
        System.out.println(json);
        str = "database/movies/"+ movie.getName()+ ".json";
        try (FileWriter writer = new FileWriter(str)) {
            gson.toJson(movie, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Usr ReadUsr(int Id) {
        Usr user = new Usr();
        str = "database/users/"+ Id+ ".json";
        try (Reader reader = new FileReader(str)) {
            user = gson.fromJson(reader, Usr.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public void SaveUsr(Usr user) {
        String json = gson.toJson(user);
        System.out.println(json);
        str = "database/users/"+ user.getId()+ ".json";
        try (FileWriter writer = new FileWriter(str)) {
            gson.toJson(user, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Movie Search(String Name){
        Movie movie = new Movie();
        
        File[] files = new File("database/movies/").listFiles();
        for (File file : files)
        {
            if (Name.equals(file.getName()))
            {
                movie = ReadMovie(Name);
                return movie;
            }
        }
        return null;
    }
}
