package oosd;

import java.util.List;

public class Movie {
    
    private int Id = 0;
    private String Name = null;
    private int Year = 0;
    private List<String> Genre = null;
    private int duration = 0;
    private String Director = null;
    //private List<String> Description;
    
    public void AddMovie() {
        System.out.print("The Movie Added ...");
    }
    
    public void EditMovie() {
        System.out.print("The Movie Edited ...");
    }
    
    //Must be edited a lot
    public void Search() {
        System.out.print("It's you movie ...");
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public List<String> getGenre() {
        return Genre;
    }

    public void setGenre(List<String> Genre) {
        this.Genre = Genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }
}
