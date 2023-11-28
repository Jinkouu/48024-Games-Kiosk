package controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.application.Platform;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class KioskController extends Controller<Kiosk> {

    private Catalogue catalogue = new Catalogue(getKiosk());
    
    
  @FXML
  public void initialize() {
      //Catalogue catalogue = new Catalogue(getKiosk());
  }

    public final Kiosk getKiosk() {
        return model;
    }
    
    public final Catalogue getCatalogue(){
        return catalogue;
    }
    
    @FXML private void handleAdmin(ActionEvent e) throws Exception{
        ViewLoader.showStage(getKiosk(), "/view/Admin.fxml", "Administration Menu", new Stage());
     }
  
    @FXML public void handleCatalogue(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/Catalogue.fxml", "Catalogue", new Stage());

     }
  
    @FXML public void handleCustomerRecord(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/CustomerRecord.fxml", "Customer Record", new Stage());
    }
    
    @FXML public void handleTopupAccount(ActionEvent e) throws IOException{
        ViewLoader.showStage(getKiosk(), "/view/TopUpAccount.fxml", "Top Up Account", new Stage());
    }
    
    @FXML public void handleFavourites(ActionEvent e) throws IOException{
         ViewLoader.showStage(getKiosk(), "/view/FavouriteGames.fxml", "Favourite Games", new Stage());
    }
  
  @FXML private void exitButtonAction(ActionEvent e) throws IOException{
      //stage.close();
      Platform.exit();
  }

}
