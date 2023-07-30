package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Catalogue;
import model.Game;
import model.Genre;
import model.Kiosk;

public class ShowGamesByGenreController extends Controller<Catalogue> {
    @FXML TableView<Game> gamesInGenreTv;
    @FXML ListView<Genre> allGenresLv;
    @FXML Button displayBtn;
    
    //public final Kiosk getKiosk(){
    //    return model;
    //}
    
    @FXML
    private void initialize() {
        allGenresLv.getSelectionModel().selectedItemProperty().addListener((observable, oldGenre, newGenre)->{
            displayBtn.setOnAction(
            event -> {
                gamesInGenreTv.setItems(getCatalogue().getGamesInGenre(newGenre));
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
    
    private Genre getSelectedGenre(){
        return allGenresLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleDisplayGames(ActionEvent e) throws IOException{
        //getCatalogue().getGamesInGenre(getSelectedGenre());
        //ViewLoader.showStage(getSelectedGenre(), "/view/ShowGamesByGenre.fxml", "Games By Genre", stage);
        System.out.println("" + getSelectedGenre());
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }
}
