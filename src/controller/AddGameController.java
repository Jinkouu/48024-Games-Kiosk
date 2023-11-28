
package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Catalogue;
import model.Kiosk;

public class AddGameController extends Controller<Kiosk> {
    @FXML private Button closeBtn;
    @FXML private TextField titleTf;
    @FXML private TextField yearTf;
    @FXML private TextField genreTf;
    @FXML private TextField priceTf;
    @FXML private Text resultTxt;
    
    private void setTitle(String title){
        titleTf.setText(title);
    }
    
    private String getTitle(){
        return titleTf.getText();
    }
    
    private void setYear(int year){
        yearTf.setText("" + year);
    }
    
    private int getYear(){
        return Integer.parseInt(yearTf.getText());
    }
    
    private void setGenre(String genre){
        genreTf.setText(genre);
    }
    
    private String getGenre(){
        return genreTf.getText();
    }
    
    private void setPrice(int price){
        priceTf.setText("" + price);
    }
    
    private int getPrice(){
        return Integer.parseInt(priceTf.getText());
    }
    
    private void setResult(String result){
        resultTxt.setText(result);
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public final Catalogue getCatalogue(){
        return model.getCatalogue();
    }
    
    @FXML private void handleAddGame(ActionEvent e) throws IOException{
        //Catalogue catalogue = new Catalogue(model);
        //Catalogue catalogue = getCatalogue();
        //setResult("Hello");
        
        
        
        try{
            String title = getTitle();
            int year = getYear();
            String genre = getGenre();
            int price = getPrice();
            if (getKiosk().getCatalogue().hasGame(title, year)){
                setResult("Failed, game already exists");
            }
            else{
                getKiosk().getCatalogue().addGame(title, getYear(), genre, price);
                setResult("Game added to Catalogue.");
            }
        }
        catch(Exception g){
            setResult("" + g);
        }
          //setResult(title + year + genre + price);  
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }
}
