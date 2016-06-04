package oosd;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonDB {
    private final Gson gson = new Gson();
    private String str = null;
    
    public Usr ReadUsr(int Id) {
        Usr user = new Usr();
        str = "database/users/"+ Id+ ".json";
        try (Reader reader = new FileReader(str)) {
            user = gson.fromJson(reader, Usr.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public void SaveUsr(Usr user) {
        String json = gson.toJson(user);
        System.out.println(json);
        str = "database/users/"+ user.getId()+ ".json";
        try (FileWriter writer = new FileWriter(str)) {
            gson.toJson(user, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
