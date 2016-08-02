package oosd;

import java.util.ArrayList;
import java.util.Arrays;
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
        this.movie = new Movie();
        char gnr = 'y';

        System.out.println("Enter Id:");
        movie.setId(input.nextInt());
        
        System.out.println("Enter Name:");
        movie.setName(input.nextLine());
        
        System.out.println("Enter Director:");
        movie.setDirector(input.nextLine());
        
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
        movie.setDescription(input.nextLine());
        
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
        
        System.out.println(Arrays.toString(movies.toArray()));

    }
    
    public void Search() {
        this.movie = new Movie();
        char gnr = 'y';
        List<Movie> movies = new ArrayList<Movie>();
        System.out.println("Fill the Fieds You Want to Search");
        
        System.out.println("Now Enter the Values ...\nPlace \'0\' or enter the new value");
        
        System.out.println("Enter Name:");
        String Name = input.nextLine();
        if(!Name.equals("0"))
        {
            movie.setName(Name);
        }
        
        System.out.println("Enter Director:");
        String Director = input.nextLine();
        if(!Director.equals("0"))
        {
            movie.setDirector(Director);
        }
        
        System.out.println("Enter Year:");
        int Year = input.nextInt();
        if(Year != 0)
        {
            movie.setYear(Year);
        }
        
        System.out.println("Enter Genre:");
        List<String> genres = new ArrayList<>();
        String Genre = input.next();
        if(!Genre.equals("0"))
        {
            genres.add(Genre);
        
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
                        System.out.println("That was not my answer!");
                }
            }
            movie.setGenre(genres);
        }
        
        System.out.println("Enter Duration:");
        int Duration = input.nextInt();
        if(Duration != 0)
        {
            movie.setDuration(Duration);
        }
        
        //movies.add(db.Search(movie));
        
        //System.out.println(Arrays.toString(movies.toArray()));
        
        System.out.println(db.Search(movie));
    }
    
    public void Edit() {
        char gnr = 'y';
        movie = Read();
        System.out.print(movie.toString());
        
        System.out.println("Now Enter the new Values ...\nPlace \'0\' or enter the new value");
        
        System.out.println("Enter Name:");
        String Name = input.next();
        if(!Name.equals("0"))
        {
            movie.setName(input.next());
        }
        
        System.out.println("Enter Director:");
        String Director = input.next();
        if(!Director.equals("0"))
        {
            movie.setDirector(input.next());
        }
        
        System.out.println("Enter Year:");
        int Year = input.nextInt();
        if(Year != 0)
        {
            movie.setYear(Year);
        }
        
        List<String> genres = new ArrayList<>();
        String Genre1 = input.next();
        if(!Genre1.equals("0"))
        {
            System.out.println("Enter Genre:");
            genres.add(Genre1);
        
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
                        System.out.println("That was not my answer!");
                }
            }
            movie.setGenre(genres);
        }
        
        System.out.println("Enter Duration:");
        int Duration = input.nextInt();
        if(Duration != 0)
        {
            movie.setDuration(Duration);
        }
        
        System.out.println("Enter Description:");
        String Description = input.next();
        if(!Description.equals("0"))
        {
            movie.setDescription(Description);
        }
        
        db.Edit(movie);
        
        System.out.println("The Movie Edited ...");
    }
}