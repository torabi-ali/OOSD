package oosd;

import java.util.Scanner;

/**
 *
 * @author ali
 */
public class OOSD {

    static final AccountController accountController = new AccountController();
    static final MovieController movieController = new MovieController();
    static final DBDriver db = new DBDriver();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int userChoice;
        userChoice = menu();

        switch (userChoice) {
            case 1:
                while (accountController.account.getId() <= 0) {
                    System.out.println("First you must sign in");
                    accountController.Login();
                }
                movieController.AddMovie();
                main(args);
                break;
            case 2:
                while (accountController.account.getId() <= 0) {
                    System.out.println("First you must sign in");
                    accountController.Login();
                }
                movieController.Edit();
                main(args);
                break;
            case 3:
                while (accountController.account.getId() <= 0) {
                    System.out.println("First you must sign in");
                    accountController.Login();
                }
                movieController.Import();
                main(args);
                break;
            case 4:
                System.out.println("Let's search for it ...");
                if (accountController.account.getId() > 0) {
                    movieController.Search();
                    main(args);
                } else {
                    movieController.SearchGuest();
                    main(args);
                }
                break;
            case 5:
                if (accountController.account.getId() > 0) {
                    accountController.Login();
                } else {
                    accountController.Edit();
                }
                main(args);
                break;
            case 6:
                accountController.SignUp();
                System.out.println("Please Login ...");
                accountController.Login();
                main(args);
                break;
            case 7:
                System.out.println("Hope to see you soon :)");
                System.exit(0);
                break;
            default:
                System.out.println("I don't know what to do :(");
                main(args);
        }
    }

    /**
     *
     * @return
     */
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("< ------------------------- >");
        System.out.println("1 - Submit Movie");
        System.out.println("2 - Edit Movie");
        System.out.println("3 - Import From Json");
        System.out.println("4 - Search");
        System.out.println("5 - Account");
        System.out.println("6 - Sign Up");
        System.out.println("7 - Quit");
        System.out.println("< ------------------------- >");

        selection = input.nextInt();
        return selection;
    }
}
