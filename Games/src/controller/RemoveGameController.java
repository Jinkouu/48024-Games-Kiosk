package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.Catalogue;
import model.Customer;
import model.Game;
import model.Kiosk;

public class RemoveGameController extends Controller<Catalogue>{
    @FXML private TableView<Game> allGamesTv;
    
    //public final Kiosk getKiosk(){
    //   return model;
    //}
    
    public final Catalogue getCatalogue(){
        return model;
    }
    
    private Game getSelectedGame(){
        return allGamesTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void removeGame(ActionEvent e) throws IOException{
        Game game = getSelectedGame();
        getCatalogue().removeGame(game);
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }

}
