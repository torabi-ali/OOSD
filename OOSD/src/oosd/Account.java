package oosd;

/**
 *
 * @author ali
 */
public class Account {

    private int Id;
    private String Password;
    private String FirstName;
    private String LastName;
    private int Score;
    private int RoleId;

    private final UserRole usrRole = new UserRole();

    /**
     * Constructor
     */
    public Account() {
        this.Id = 0;
        this.Password = null;
        this.FirstName = null;
        this.LastName = null;
        this.Score = 0;
        this.RoleId = usrRole.getRole().indexOf("Null");
    }

    /**
     *
     * @return
     */
    public int getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     *
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     *
     * @param FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return LastName;
    }

    /**
     *
     * @param LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     *
     * @return
     */
    public int getScore() {
        return Score;
    }

    /**
     *
     * @param Score
     */
    public void setScore(int Score) {
        this.Score = Score;
    }

    /**
     *
     * @return
     */
    public int getRoleId() {
        return RoleId;
    }

    /**
     *
     * @param RoleId
     */
    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n------------------------------"
                + "\nID: " + getId()
                + "\nFirstName: " + getFirstName()
                + "\nLastName: " + getLastName()
                + "\nScore: " + getScore()
                + "\nRole: " + getRoleId()
                + "\n------------------------------\n";
    }
}
