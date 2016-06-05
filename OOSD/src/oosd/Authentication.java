package oosd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {
    Usr user = new Usr();
    JsonDB json = new JsonDB();
    Scanner input = new Scanner(System.in);
    //DBConnection conn = new DBConnection();

    public void AddMovie() {
        Movie movie = new Movie();
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
        
        json.SaveMovie(movie);
        
        System.out.print("The Movie Added ...");
    }
    
    public void Search() {
        Movie movie = new Movie();
        
        System.out.println("Enter the Name:");
        System.out.println(json.Search(input.next()));
    }
    
    public Usr Login() {
        int Id;
        System.out.print("Enter your ID:");
        Id = input.nextInt();
        user.setId(Id);

        String Password;
        System.out.print("Enter your Password:");
        Password = input.next();
        user.setPassword(Password);
        
        user = json.ReadUsr(Id);
        if(user != null)
        {
            if (user.getPassword().equals(Password))
            {
                System.out.println("You are Logged in :)");
                return user;
            }
            System.out.println("The Username or Password was not correct");
        }
        System.out.println("The Username not found");
        return null;
    }
    
    public void SignUp() {        
        int Id;
        System.out.print("Enter your ID:");
        Id = input.nextInt();
        user.setId(Id);

        String Password;
        System.out.print("Enter your Password:");
        Password = input.next();
        user.setPassword(Password);
        
        String FirstName;
        System.out.print("Enter your FirstName:");
        FirstName = input.next();
        user.setFirstName(FirstName);
        
        String LastName;
        System.out.print("Enter your FirstName:");
        LastName = input.next();
        user.setLastName(LastName);

        json.SaveUsr(user);
        
        System.out.println("you are signed up completely ...");
    }
}
