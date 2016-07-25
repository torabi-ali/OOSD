package oosd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieController {
    Movie movie;
    JsonDB json;
    SqlDB sql;
    Scanner input = new Scanner(System.in);
    
    public MovieController() {
        movie = new Movie();
        json = new JsonDB();
        sql = new SqlDB();
    }
    
    public void AddMovie() {
        char gnr = 'y';

        System.out.print("Enter Id:");
        movie.setId(input.nextInt());
        
        System.out.print("Enter Name:");
        movie.setName(input.next());
        
        System.out.print("Enter Director:");
        movie.setDirector(input.next());
        
        System.out.print("Enter Year:");
        movie.setYear(input.nextInt());
        
        List<String> genres = new ArrayList<>();
        System.out.print("Enter Genre:");
        genres.add(input.next());
        
        while (gnr == 'y' || gnr == 'Y')
        {
            System.out.print("Do You Want to Add More Genres?(Y/N)");
            gnr = input.next().charAt(0);
            switch (gnr) {
                case 'y':
                case 'Y':
                    System.out.print("Enter Genre:");
                    genres.add(input.next());
                    break;
                case 'n':
                case 'N':
                    gnr = 'n';
                    break;
                default:
                    System.out.print("That was not my asnwer!");
            }
        }
        movie.setGenre(genres);

        System.out.print("Enter Duration:");
        movie.setDuration(input.nextInt());
        
        System.out.print("Enter Description:");
        movie.setDescription(input.next());
        
        json.Save(movie);
        
        try {
            sql.Save(movie);
        } catch (SQLException ex) {
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.print("The Movie Added ...");
    }
}