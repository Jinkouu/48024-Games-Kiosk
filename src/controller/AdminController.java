package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Kiosk;

public class AdminController extends Controller<Kiosk>{
    
    @FXML private Button exitButton;
    
    private final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private void handleShowAllCustomers(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/ShowAllCustomers.fxml", "All Customers", new Stage());
     }
    
    @FXML public void handleAddCustomers(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/AddCustomer.fxml", "Add Customer", new Stage());
     }
    
    @FXML public void handleRemoveCustomers(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
     }
    
    @FXML public void handleShowAllGames(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/ShowAllGames.fxml", "All Games", new Stage());
     }
    
    @FXML public void handleAddGames(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/AddGame.fxml", "Add Games", new Stage());
     }
    
    @FXML public void handleRemoveGames(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk().getCatalogue(), "/view/RemoveGame.fxml", "Remove Games", new Stage());
     }
    
    @FXML private void exitButtonAction(ActionEvent e) throws IOException{
        stage.close();
    }
}
