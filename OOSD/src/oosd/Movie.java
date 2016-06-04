package oosd;

public class Movie {
    private int Id;
    private String Name;
    private String Director;
    private int year;
    private int Imdb;
    
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

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getImdb() {
        return Imdb;
    }

    public void setImdb(int Imdb) {
        this.Imdb = Imdb;
    }
}
