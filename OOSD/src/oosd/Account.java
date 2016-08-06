package oosd;

public class Account {

    private int Id;
    private String Password;
    private String FirstName;
    private String LastName;
    private int Score;
    private int RoleId;

    private final UserRole usrRole = new UserRole();

    public Account() {
        this.Id = 0;
        this.Password = null;
        this.FirstName = null;
        this.LastName = null;
        this.Score = 0;
        this.RoleId = usrRole.getRole().indexOf("Null");
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
    }

    @Override
    public String toString() {
        return "\n------------------------------"
                + "\nID: " + getId()
                + "\nFirstName: " + getFirstName()
                + "\nLastName: " + getLastName()
                + "\nScore: " + getScore()
                + "\n------------------------------\n";
    }
}
