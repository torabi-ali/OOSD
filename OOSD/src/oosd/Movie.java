package oosd;

import java.util.List;

public class Movie {
    
    private int Id;
    private String Name;
    private int Year;
    private List<String> Genre;
    private int duration;
    private String Director;
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
