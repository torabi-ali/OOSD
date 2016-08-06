package oosd;

import java.util.ArrayList;
import java.util.List;

public class UserRole {

    List<String> Role = new ArrayList<>();

    DBDriver db;

    public void UserRole() {
        db = new DBDriver();

        Role.addAll(db.GetRole());
    }

    public void addRole(String role) {
        this.Role.add(role);
    }

    public List<String> getRole() {
        return Role;
    }

    public void setRole(List<String> Role) {
        this.Role = Role;
    }
}
