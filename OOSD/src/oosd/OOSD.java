package oosd;

import java.util.Scanner;

public class OOSD {

    static final Authentication auth = new Authentication();
    static final Usr user = new Usr();
    static final Movie movie = new Movie();

    public static void main(String[] args) {
        int userChoice;
        userChoice = menu();
                
        switch (userChoice) {
            case 1:
                if (user.getId() > 0)
                {
                    movie.AddMovie();
                }
                else
                {
                    System.out.println("First you must sign in");
                    auth.SignUp();
                }
                break;
            case 2:
                if (user.getId() > 0)
                {
                    movie.EditMovie();
                }
                else
                {
                    System.out.println("First you must sign in");
                    auth.SignUp();
                }
                break;
            case 3:
                movie.Search();
                break;
            case 4:
                auth.Login();
                break;
            case 5:
                auth.SignUp();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("I don't know what to do :(");
        }
    }
    
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Please order us ...");
        System.out.println("-------------------------\n");
        System.out.println("1 - Sign in a Movie");
        System.out.println("2 - Edit a Movie");
        System.out.println("3 - Search");
        System.out.println("4 - Login");
        System.out.println("5 - Sign Up");
        System.out.println("6 - Quit");

        selection = input.nextInt();
        return selection;
    }
}
