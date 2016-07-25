package oosd;

import java.util.Scanner;

public class AccountController {
    Account account;
    JsonDB json;
    Scanner input = new Scanner(System.in);
    
    public AccountController() {
        account = new Account();
        json = new JsonDB();
    }
    
    public Account Login() {
        int Id;
        System.out.print("Enter your ID:");
        Id = input.nextInt();
        account.setId(Id);

        String Password;
        System.out.print("Enter your Password:");
        Password = input.next();
        account.setPassword(Password);
        
        account = json.Read(Id);
        if(account != null)
        {
            if (account.getPassword().equals(Password))
            {
                System.out.println("You are Logged in :)");
                return account;
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
        account.setId(Id);

        String Password;
        System.out.print("Enter your Password:");
        Password = input.next();
        account.setPassword(Password);
        
        String FirstName;
        System.out.print("Enter your FirstName:");
        FirstName = input.next();
        account.setFirstName(FirstName);
        
        String LastName;
        System.out.print("Enter your LastName:");
        LastName = input.next();
        account.setLastName(LastName);

        json.Save(account);
        
        System.out.println("you are signed up completely ...");
    }
}
