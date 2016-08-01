package oosd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static oosd.OOSD.db;

public class MovieController {
    Scanner input;
    Movie movie;
    
    public MovieController() {
        this.input = new Scanner(System.in);
        this.movie = new Movie();
    }
    
    public void AddMovie() {
        char gnr = 'y';

        System.out.println("Enter Id:");
        movie.setId(input.nextInt());
        
        System.out.println("Enter Name:");
        movie.setName(input.next());
        
        System.out.println("Enter Director:");
        movie.setDirector(input.next());
        
        System.out.println("Enter Year:");
        movie.setYear(input.nextInt());
        
        List<String> genres = new ArrayList<>();
        System.out.println("Enter Genre:");
        genres.add(input.next());
        
        while (gnr == 'y' || gnr == 'Y')
        {
            System.out.println("Do You Want to Add More Genres?(Y/N)");
            gnr = input.next().charAt(0);
            switch (gnr) {
                case 'y':
                case 'Y':
                    System.out.println("Enter Genre:");
                    genres.add(input.next());
                    break;
                case 'n':
                case 'N':
                    gnr = 'n';
                    break;
                default:
                    System.out.println("That was not my asnwer!");
            }
        }
        movie.setGenre(genres);

        System.out.println("Enter Duration:");
        movie.setDuration(input.nextInt());
        
        System.out.println("Enter Description:");
        movie.setDescription(input.next());
        
        db.Save(movie);
        
        System.out.println("The Movie Added ...");
    }
    
    public Movie Read() {
        System.out.println("Enter Id:");
        int Id = input.nextInt();
        
        movie = db.ReadMovie(Id);
        
        return movie;
    }
    
    public void ReadAll() {        
        System.out.println("Here are the whole movies:");
        List<Movie> movies = new ArrayList<Movie>();
        
        movies = (List<Movie>) db.ReadAllMovies();
        
        for(Movie all_movie: movies)
        {   
            System.out.print(all_movie.toString());
        }
    }
}