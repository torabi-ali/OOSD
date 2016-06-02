/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd;

import java.sql.PreparedStatement;

/**
 *
 * @author ali
 */
public class SignUp {
    User user;
    DBConnection conn = new DBConnection();

    public SignUp(int Id, String FirstName, String LastName) {
        user.setId(Id);
        user.setFirstName(FirstName);
        user.setLastName(LastName);
        
        System.out.println("you are signed up completely ...");
    }
}
