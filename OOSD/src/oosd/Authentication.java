package oosd;

import java.util.Scanner;

public class Authentication {
    Usr user = new Usr();
    JsonDB json = new JsonDB();
    Scanner input = new Scanner(System.in);
    //DBConnection conn = new DBConnection();

    public Usr Login() {
        int Id;
        System.out.print("Enter your ID:");
        Id = input.nextInt();
        user.setId(Id);

        String Password;
        System.out.print("Enter your Password:");
        Password = input.next();
        user.setPassword(Password);
        
        //Should read from database
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
