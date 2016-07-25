package oosd;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBDriver {
    JsonDB json;
    SqlDB sql;
    Account account;
    Movie movie;
    
    public DBDriver() {
        this.json = new JsonDB();
        this.sql = new SqlDB();
    }
    
    public Account Read(int Id) {
        account = json.Read(Id);
        return account;
    }
    
    public void Save(Movie movie) {
        json.Save(movie);
        
        try {
            sql.Save(movie);
        } catch (SQLException ex) {
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Save(Account account) {
        json.Save(account);
        
        try {
            sql.Save(account);
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
