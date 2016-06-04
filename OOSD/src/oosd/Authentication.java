package oosd;

import java.util.Scanner;

public class Authentication {
    Usr user;
    //DBConnection conn = new DBConnection();

    public void Login(){
        Scanner input = new Scanner(System.in);
        
        int Id;
        System.out.print("Enter your ID:");
        Id = input.nextInt();
        user.setId(Id);

        String Password;
        System.out.print("Enter your Password:");
        Password = input.next();
        user.setPassword(Password);
        
        //Should read from database
        if (Password != null)
        {
            user.setId(Id);
        }
    }
    
    public void SignUp() {
        Scanner input = new Scanner(System.in);
        
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
        
        //Should connect to database and insert the data
        
        System.out.println("you are signed up completely ...");
    }
}
