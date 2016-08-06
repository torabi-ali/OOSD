package oosd;

import java.util.Scanner;
import static oosd.OOSD.db;

/**
 *
 * @author ali
 */
public class AccountController {

    Scanner input;
    Account account;
    UserRole userRole;

    /**
     * Constructor
     */
    public AccountController() {
        this.input = new Scanner(System.in);
        this.account = new Account();
        this.userRole = new UserRole();
    }

    /**
     *
     * @return
     */
    public Account Login() {
        int Id;
        System.out.println("Enter your ID:");
        Id = input.nextInt();
        account.setId(Id);

        String Password;
        System.out.println("Enter your Password:");
        Password = input.next();
        account.setPassword(Password);

        account = db.ReadAccount(Id);

        if (account.getId() > 0) {
            if (account.getPassword().equals(Password)) {
                System.out.println("You are Logged in :)");
                return account;
            }
            System.out.println("The Username or Password was not correct");
        } else {
            System.out.println("The Username not found");
        }
        return null;
    }

    /**
     *
     * @return
     */
    public Account Read() {
        System.out.println("Enter Id:");
        int Id = input.nextInt();

        account = db.ReadAccount(Id);

        return account;
    }

    /**
     * Edit
     */
    public void Edit() {
        account = Read();
        account.toString();

        System.out.println("Now Enter the new Values ...\nPlace \'0\' or enter the new value");

        System.out.println("Enter Password:");
        String Password = input.next();
        if (!Password.equals("0")) {
            account.setPassword(Password);
        }

        System.out.println("Enter FirstName:");
        String FirstName = input.next();
        if (!FirstName.equals("0")) {
            account.setPassword(FirstName);
        }

        System.out.println("Enter LastName:");
        String LastName = input.next();
        if (!LastName.equals("0")) {
            account.setPassword(LastName);
        }

        db.Edit(account);

        System.out.println("you're account is now modified ...");
    }

    /**
     * Sign Up
     */
    public void SignUp() {
        int Id;
        System.out.println("Enter your ID:");
        Id = input.nextInt();
        account.setId(Id);

        String Password;
        System.out.println("Enter your Password:");
        Password = input.next();
        account.setPassword(Password);

        String FirstName;
        System.out.println("Enter your FirstName:");
        FirstName = input.next();
        account.setFirstName(FirstName);

        String LastName;
        System.out.println("Enter your LastName:");
        LastName = input.next();
        account.setLastName(LastName);

        //account.setRoleId(userRole.getRole().indexOf("User"));
        account.setRoleId(1);

        db.Save(account);

        System.out.println("you are signed up seccessfully ...");
    }
}
