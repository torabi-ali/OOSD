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
}
