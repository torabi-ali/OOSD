package oosd;

public class Usr {
    private int Id;
    private String Password;
    private String FirstName;
    private String LastName;
    private int Score;

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
}