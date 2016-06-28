package oosd;

import java.util.Scanner;

public class OOSD {

    static final DBDriver auth = new DBDriver();
    static final DBConnection db = new DBConnection();
    static final Usr user = new Usr();
    static final Movie movie = new Movie();

    public static void main(String[] args) {
        int userChoice;
        userChoice = menu();
                
        switch (userChoice) {
            case 1:
                if (user.getId() > 0)
                {
                    auth.AddMovie();
                    main(args);
                }
                else
                {
                    System.out.println("First you must sign in");
                    auth.Login();
                    auth.AddMovie();
                    main(args);
                }
                break;
            case 2:
                if (user.getId() > 0)
                {
                    //movie.EditMovie();
                    main(args);
                }
                else
                {
                    System.out.println("First you must sign in");
                    auth.Login();
                    //movie.EditMovie();
                    main(args);
                }
                break;
            case 3:
                auth.Search();
                break;
            case 4:
                auth.Login();
                main(args);
                break;
            case 5:
                auth.SignUp();
                auth.Login();
                break;
            case 6:
                System.out.println("Hope to see you soon :)");
                System.exit(0);
                break;
            default:
                System.out.println("I don't know what to do :(");
        }
    }
    
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("< ------------------------- >");
        System.out.println("1 - Sign in a Movie");
        System.out.println("2 - Edit a Movie");
        System.out.println("3 - Search");
        System.out.println("4 - Login");
        System.out.println("5 - Sign Up");
        System.out.println("6 - Quit");
        System.out.println("< ------------------------- >");

        selection = input.nextInt();
        return selection;
    }
}
