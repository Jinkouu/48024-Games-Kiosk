
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

public class CatalogueController extends Controller<Kiosk>{
    
    private final Kiosk getKiosk(){
        return model;
    }
    
    @FXML public void handleAllGames(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/ShowAllGames.fxml", "All Games", new Stage());
     }
    
    @FXML public void handleAvailableGames(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/ShowAvailableGames.fxml", "Available Games", new Stage());
     }
    
    @FXML public void handleGamesByGenre(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk().getCatalogue(), "/view/ShowGamesByGenre.fxml", "Games By Genre", new Stage());
     }
    
    @FXML public void handleGamesByYear(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk().getCatalogue(), "/view/ShowGamesByYear.fxml", "Games By Year", new Stage());
     }
    
    @FXML public void handleRentGames(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/RentGame.fxml", "Rent Games", new Stage());
     }
    
    @FXML public void handleReturnGames(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/ReturnGame.fxml", "Return Games", new Stage());
     }
    
    @FXML private void exitButtonAction(ActionEvent e) throws IOException{
        stage.close();
    }
    
}
