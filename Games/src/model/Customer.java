package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {

    private int ID;
    private String name;
    private int balance;
    private ObservableList<Game> currentlyRented;
    private ObservableList<Game> rentingHistory;

    public Customer(int ID, String name, int balance) {

        this.ID = ID;
        this.name = name;
        this.balance = balance;
        this.currentlyRented = FXCollections.observableArrayList();
        this.rentingHistory = FXCollections.observableArrayList();

    }

    @Override
    public String toString() {
        return ID + "\t" + name + "\t$ "+ balance;
    }

    public ObservableList<Game> favouriteGames() {

        ObservableList<Game> favourites = FXCollections.observableArrayList();

        if (!rentingHistory.isEmpty()) {

            int[] favouriteCount = new int[rentingHistory.size()];

            for (Game m : rentingHistory) {
                favouriteCount[rentingHistory.indexOf(m)]++;
            }

            int first = max(favouriteCount);

            if (first > -1) {
                favourites.add(this.rentingHistory.get(first));
                favouriteCount[first] = 0;
            }

            int second = max(favouriteCount);

            if (second > -1) {
                favourites.add(this.rentingHistory.get(second));
                favouriteCount[second] = 0;
            }

            int third = max(favouriteCount);

            if (third > -1) {
                favourites.add(this.rentingHistory.get(third));
            }
        }
        return favourites;
    }

    private int max(int[] a) {

        int max = Integer.MIN_VALUE;
        int maxPosition = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && a[i] > max) {
                max = a[i];
                maxPosition = i;
            }
        }

        return maxPosition;
    }

   /* public void show() {
        
        System.out.println("ID: "+this.ID);
        System.out.println("Name: "+this.name);
        System.out.println("Balance: $"+this.balance);
        
    }
*/
    public void rentGame(Game game) {

        //check balance
        currentlyRented.add(game);
        rentingHistory.add(game);
        

    }
   
    public void deductAmount(int amount) {
        this.balance -= amount;
    }
    
    public void topUpAccount(int amount) {
        this.balance += amount;
    }
    
    public void returnGame(Game game) {

        if (currentlyRented.contains(game)) {
            currentlyRented.remove(game);
        }

    }

    public boolean hasGame(Game game) {
        return currentlyRented.contains(game);
    }

    public boolean hasGame(String title) {

        for (Game m : this.currentlyRented) {
            if (m.titleMatches(title))
                return true;
        }

        return false;
    }

    public int getId() {
        return this.ID;
    }

    public int getBalance() {
        return this.balance;
    }
    
    public String getName() {
        return this.name;
    }

    public ObservableList<Game> currentlyRented() {
        return this.currentlyRented;
    }

    public ObservableList<Game> rentingHistory() {
        return this.rentingHistory;
    }

}
