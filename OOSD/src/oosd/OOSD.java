/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd;

import java.sql.SQLException;

/**
 *
 * @author ali
 */
public class OOSD {
    
    static final DBConnection conn = new DBConnection();
    
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello, World");
        
        conn.connect();
    }
}
