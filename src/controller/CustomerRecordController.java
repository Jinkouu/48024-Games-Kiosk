
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
import javafx.stage.Stage;
import model.Game;
import model.Kiosk;
import model.Customer;

public class CustomerRecordController extends Controller<Kiosk>{
    @FXML private TableView<Game> rentedGamesTv;
    @FXML private TableView<Game> rentingHistoryTv;
    @FXML private TextField idTf;
    @FXML private Button selectBtn;
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
                            setResult(getKiosk().getCustomer(getId())); 
                            rentedGamesTv.setItems(getKiosk().getCustomer(getId()).currentlyRented());
                            rentingHistoryTv.setItems(getKiosk().getCustomer(getId()).rentingHistory());
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
    }
    
    public final Kiosk getKiosk(){
        return model;
    }
    
    
    private int getId(){ 
        return Integer.parseInt(idTf.getText());
    }
    
    private void setId(int id){ 
        idTf.setText("" + id); 
    }
    
    private void setResult(Customer input){
        resultTxt.setText("" + input);
    }
    
    private void setResult(String input){
        resultTxt.setText("" + input);
    }
    
    
    
    @FXML private void handleSelectCustomer(ActionEvent event) throws IOException {
        try{
            Customer customer = getKiosk().getCustomer(getId());
            if (getKiosk().getCustomer(getId()) != null){
                setResult(customer);    
            }
        }
        catch(Exception g){
            setResult("" + g);
        }
        //ViewLoader.showStage(getCustomerz(getId()), "/view/CustomerRecord.fxml", "Customer Record", stage);
        
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }
}
