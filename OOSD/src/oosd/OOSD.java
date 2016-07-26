package oosd;

import java.util.Scanner;

public class OOSD {
    static final AccountController accountController = new AccountController();
    static final MovieController movieController = new MovieController();
    static final DBDriver db = new DBDriver();

    public static void main(String[] args) {
        int userChoice;
        userChoice = menu();
                
        switch (userChoice) {
            case 1:
                if (accountController.account.getId() > 0)
                {
                    movieController.AddMovie();
                    main(args);
                }
                else
                {
                    System.out.println("First you must sign in");
                    accountController.Login();
                    movieController.AddMovie();
                    main(args);
                }
                break;
            case 2:
                if (accountController.account.getId() > 0)
                {
                    //movie.EditMovie();
                    main(args);
                }
                else
                {
                    System.out.println("First you must sign in");
                    accountController.Login();
                    //movie.EditMovie();
                    main(args);
                }
                break;
            case 3:
                movieController.Read();
                break;
            case 4:
                accountController.Login();
                main(args);
                break;
            case 5:
                accountController.SignUp();
                System.out.println("Please Login ...");
                accountController.Login();
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
