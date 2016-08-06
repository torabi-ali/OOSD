package oosd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ali
 */
public class Movie {

    private int Id;
    private String Name;
    private int Year;
    private List<String> Genre;
    private int Duration;
    private String Director;
    private String Description;

    /**
     * Constructor
     */
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
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     */
    public int getYear() {
        return Year;
    }

    /**
     *
     * @param Year
     */
    public void setYear(int Year) {
        this.Year = Year;
    }

    /**
     *
     * @return
     */
    public List<String> getGenre() {
        return Genre;
    }

    /**
     *
     * @param Genre
     */
    public void setGenre(List<String> Genre) {
        this.Genre = Genre;
    }

    /**
     *
     * @return
     */
    public int getDuration() {
        return Duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(int duration) {
        this.Duration = duration;
    }

    /**
     *
     * @return
     */
    public String getDirector() {
        return Director;
    }

    /**
     *
     * @param Director
     */
    public void setDirector(String Director) {
        this.Director = Director;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return Description;
    }

    /**
     *
     * @param Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n------------------------------"
                + "\nID: " + getId()
                + "\nName: " + getName()
                + "\nYear: " + getYear()
                + "\nDirector: " + getDirector()
                + "\nGenre: " + getGenre()
                + "\nDuration: " + getDuration()
                + "\nDescription: " + getDescription()
                + "\n------------------------------\n";
    }
}
