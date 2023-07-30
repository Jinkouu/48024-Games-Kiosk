package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.Catalogue;
import model.Game;
import model.Genre;
import model.Kiosk;

public class ShowGamesByYearController extends Controller<Catalogue> {
    @FXML TableView<Game> gamesInYearTv;
    @FXML ListView<Integer> allYearsLv;
    @FXML private Button displayBtn;
    
    @FXML
    private void initialize() {
        allYearsLv.getSelectionModel().selectedItemProperty().addListener((observable, oldYear, newYear)->{
            displayBtn.setOnAction(
            event -> {
                gamesInYearTv.setItems(getCatalogue().getGamesByYear(newYear));
            });
        });
        
        //gamesInGenreTv.setItems(getCatalogue().getGamesInGenre(genre));
        //displayBtn.onActionProperty().addListener(
        //        (observable, oldGenre, newGenre) -> gamesInGenreTv.setItems(getCatalogue().getGamesInGenre(getSelectedGenre()))
        //);
    }
    
    public final Catalogue getCatalogue(){
        return model;
    }
    
    private int getSelectedYear(){
        return allYearsLv.getSelectionModel().getSelectedItem().intValue();
    }
    
    @FXML private void handleDisplayGames(ActionEvent e) throws IOException{        
        getCatalogue().getGamesByYear(getSelectedYear());
        
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }
}
