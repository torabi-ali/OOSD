package oosd;

import java.util.Scanner;
import static oosd.OOSD.db;

public class AccountController {

    Scanner input;
    Account account;
    UserRole userRole;

    public AccountController() {
        this.input = new Scanner(System.in);
        this.account = new Account();
        this.userRole = new UserRole();
    }

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

        account.setRoleId(userRole.getRole().indexOf("User"));

        db.Save(account);

        System.out.println("you are signed up completely ...");
    }
}
