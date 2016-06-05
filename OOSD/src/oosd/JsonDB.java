package oosd;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonDB {
    static final Gson gson = new Gson();
    
    public void ReadUsr() {
        Usr user = new Usr();
        try (Reader reader = new FileReader("database/User.json")) {
            user = gson.fromJson(reader, Usr.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void SaveUsr(Usr user) {
        String json = gson.toJson(user);
        System.out.println(json);
        
        try (FileWriter writer = new FileWriter("database/User.json")) {
            gson.toJson(user, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
