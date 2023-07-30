package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Catalogue {

    private final Kiosk kiosk;
    private final ObservableList<Game> gamesAvailable;
    private final ObservableList<Game> gamesRented;
    private final ObservableList<Genre> genres;

    public Catalogue(Kiosk kiosk) {
        this.kiosk = kiosk;
        gamesAvailable = FXCollections.observableArrayList();
        gamesRented = FXCollections.observableArrayList();
        genres = FXCollections.observableArrayList();
                
        //DATA BASE OF GAMES
        Genre g = new Genre("Action Queue");
        addGenre(g);
        
        gamesAvailable.add(new Game("Robinson Crusoe", 2012, g, 3));
       
        
        g = new Genre("Role Playing");
        addGenre(g);
        
        gamesAvailable.add(new Game("Talisman", 2007, g, 4));
                        
        g = new Genre("Hand Management");
        addGenre(g);
        gamesAvailable.add(new Game("Three Kingdoms Redux", 2014, g, 3));
  
        g = new Genre("Modular Board");
        addGenre(g);
        gamesAvailable.add(new Game("Dungeons & Dragons", 2010, g, 4));
        gamesAvailable.add(new Game("Elder Sign", 2011, g, 3));
        
        
    }


    private void addGame(Game game) {

        if (!gamesAvailable.contains(game))
            gamesAvailable.add(game);

    }

    public void addGame(String title, int year, String genre, int price) {
        Genre g = oldGenre(genre) ? retrieveGenre(genre) : new Genre(genre);
        addGenre(g);

        this.addGame(new Game(title, year, g, price));
    }

    private void addGenre(Genre genre) {

        if (!genres.contains(genre))
            genres.add(genre);

    }

    public ObservableList<Game> getAllGames() {

        ObservableList<Game> allGames = FXCollections.observableArrayList();        
        allGames.addAll(gamesRented);
        allGames.addAll(gamesAvailable);        
        return allGames;
    }

    public ObservableList<Game> getAvailableGames() {
        return this.gamesAvailable;
    }

    private Game getGameByTitle(String title) {
        for (Game b : this.getAllGames()) {
            if (b.titleMatches(title))
                return b;
        }

        return null;
    }

    public boolean rentGameToCustomer(Game game, Customer customer) {
        if(customer.getBalance() >= game.getPrice()) {
            customer.rentGame(game);
            customer.deductAmount(game.getPrice());
            gamesRented.add(game);
            gamesAvailable.remove(game); 
            return true;
        }
        return false;
    }

    private boolean oldGenre(String genre) {

        for (Genre g : this.genres) {
            if (g.isSameGenreAs(genre))
                return true;
        }

        return false;
    }

    private Genre retrieveGenre(String genre) {

        for (Genre g : this.genres) {
            if (g.isSameGenreAs(genre))
                return g;
        }

        return null;
    }

    public boolean returnGameFromCustomer(Game game, Customer customer) {

        if (customer.hasGame(game)) {

            customer.returnGame(game);
            gamesRented.remove(game);
            gamesAvailable.add(game);
            return true;

        }
        return false;
    }
    
    public boolean hasGame(String title, int year) {

        for (Game m : this.getAllGames()) {
            if (m.titleMatches(title) && m.getYear() == year) {
                return true;
            }
        }

        return false;
    }
    
    public void removeGame(Game game) {
        this.gamesAvailable.remove(game);
        Genre genre = game.getGenre();
         
         if (this.getGamesInGenre(genre).isEmpty()) {
            genres.remove(genre);
        }
    }
   
    public ObservableList<Game> getGamesInGenre(Genre genre) {
        ObservableList<Game> gamesInGenre = FXCollections.observableArrayList();

        for (Game m : this.getAllGames()) {
            if (m.getGenre().isSameGenreAs(genre)) {
                gamesInGenre.add(m);
            }
        }

        return gamesInGenre;
    }
          
    public ObservableList<Game> getGamesByYear(int year) {

       ObservableList<Game> gamesByYear = FXCollections.observableArrayList();

        for (Game m : this.getAllGames()) {
            if (m.getYear() == year) {
                gamesByYear.add(m);
            }
        }
        
        return gamesByYear;     
    }

    public ObservableList<Genre> getGenres() {
        return this.genres;
    }
    
    public ObservableList<Integer> getYears() {
        ObservableList<Integer> availableYears = FXCollections.observableArrayList();

        for (Game m : this.getAllGames()) {
            int year = m.getYear();
            if(!availableYears.contains(year))
                availableYears.add(year);
            
        }
        
        return availableYears;    
    }
    
    public Customer getCustomer(int id) {
        return this.kiosk.getCustomer(id);
    }
}