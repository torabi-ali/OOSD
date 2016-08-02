package oosd;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private int Id;
    private String Name;
    private int Year;
    private List<String> Genre;
    private int Duration;
    private String Director;
    private String Description;
    
    public Movie() {
        Id = 0;
        Name = null;
        Director = null;
        Year = 0;
        Genre = new ArrayList<>();
        Genre = null;
        Duration = 0;        
        Description = null;
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
        return Duration;
    }

    public void setDuration(int duration) {
        this.Duration = duration;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    @Override
    public String toString() {
      return "\n------------------------------"+
             "\nID: "+ getId()+
             "\nName: "+ getName()+
             "\nYear: "+ getYear()+
             "\nDirector: "+ getDirector()+
             "\nGenre: "+ getGenre()+
             "\nDuration: "+ getDuration()+
             "\nDescription: "+ getDescription()+
             "\n------------------------------\n";
    }
}