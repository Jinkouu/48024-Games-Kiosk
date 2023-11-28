package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Catalogue;
import model.Game;
import model.Kiosk;

public class ShowAvailableGamesController extends Controller<Kiosk> {
    @FXML private Button closeBtn;
    @FXML TableView<Game> gamesAvailableTv;
    
    public final Kiosk getKiosk(){
        return model;
    }
    
    public final Catalogue getCatalogue(){
        return getKiosk().getCatalogue();
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }
}
