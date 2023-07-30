package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Catalogue;
import model.Customer;
import model.Game;
import model.Kiosk;

public class RentGameController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private TableView<Game> gamesAvailableTv;
    @FXML private Button selectBtn;
    @FXML private Button rentBtn;
    @FXML private Text resultTxt;
    
    @FXML
    private void initialize() {
        idTf.textProperty().addListener(
                (observable, oldText, newText) -> selectBtn.setDisable(newText.isEmpty())
        );
        
        selectBtn.setOnAction(
                event -> {
                    try{
                        if (getKiosk().getCustomer(getId()) != null){
                            gamesAvailableTv.setItems(getKiosk().getCatalogue().getAvailableGames());
                        }
                        else{
                            setResult("Customer does not exist.");
                        }
                    }
                    catch(Exception e){
                        setResult("" + e);
                    }
                }
        );
        
        gamesAvailableTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldGame, newGame) -> rentBtn.setDisable(newGame == null)
        );
    }
    
    public final Kiosk getKiosk(){
        return model;
    }
    
    public final Catalogue getCatalogue(){
        return getKiosk().getCatalogue();
    }
    
    private int getId(){ 
        return Integer.parseInt(idTf.getText());
    }
    
    private void setId(int id){ 
        idTf.setText("" + id); 
    }
    
    private void setResult(String input){
        resultTxt.setText("" + input);
    }
    
    private Game getSelectedGame(){
        return gamesAvailableTv.getSelectionModel().getSelectedItem();
    }
    
    
    @FXML private void handleSelectCustomer(ActionEvent event) throws IOException {
        Customer customer = getKiosk().getCustomer(getId());
        
        if (getKiosk().getCustomer(getId()) != null){
            //setResult(customer);    
        }
        else{
            setResult("Customer does not exist.");
        }
    }
    
    @FXML private void handleRent(ActionEvent event) throws IOException {
        
        try{
            Game game = getSelectedGame();
            Customer customer = getKiosk().getCustomer(getId());
            if(getKiosk().getCustomer(getId()).getBalance() > getSelectedGame().getPrice()){
                getCatalogue().rentGameToCustomer(game, customer);
                setResult("Game Rented.");
            }
            else{
                setResult("Insufficient funds.");
            }
        }
        catch(Exception e){
            setResult("" + e);
        }
        
    }
    
    @FXML private void handleClose(ActionEvent event) throws IOException {
        stage.close();
    }
}
