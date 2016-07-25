package oosd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieController {
    Movie movie;
    JsonDB json;
    Scanner input = new Scanner(System.in);
    
    public MovieController() {
        movie = new Movie();
        json = new JsonDB();
    }
    
    public void AddMovie() {
        char gnr;
        
        System.out.print("Enter Name:");
        movie.setName(input.next());
        
        System.out.print("Enter Director:");
        movie.setDirector(input.next());
        
        System.out.print("Enter Year:");
        movie.setYear(input.nextInt());
        
        List<String> genres = new ArrayList<>();
        System.out.print("Enter Genre:");
        genres.add(input.next());
        System.out.print("Do You Want to Add More Genres?(Y/N)");
        gnr = input.next().charAt(0);
        while (gnr == 'y')
        {
            System.out.print("Enter Genre:");
            genres.add(input.next());
            System.out.print("Do You Want to Add More Genres?(Y/N)");
            gnr = input.next().charAt(0);
        }
        movie.setGenre(genres);

        System.out.print("Enter Duration:");
        movie.setDuration(input.nextInt());
        
        System.out.print("Enter Description:");
        movie.setDescription(input.next());
        
        json.Save(movie);
        
        System.out.print("The Movie Added ...");
    }
}