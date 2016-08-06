package oosd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ali
 */
public class UserRole {

    List<String> Role = new ArrayList<>();

    DBDriver db;

    /**
     * Contructor
     */
    public void UserRole() {
        db = new DBDriver();

        Role.addAll(db.GetRole());
    }

    /**
     *
     * @param role
     */
    public void addRole(String role) {
        this.Role.add(role);
    }

    /**
     *
     * @return
     */
    public List<String> getRole() {
        return Role;
    }

    /**
     *
     * @param Role
     */
    public void setRole(List<String> Role) {
        this.Role = Role;
    }
}
