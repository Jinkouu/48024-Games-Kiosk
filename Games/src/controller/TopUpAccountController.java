package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Customer;
import model.Kiosk;

public class TopUpAccountController extends Controller<Kiosk> {
    @FXML private Text result;
    @FXML private TextField idTf;
    @FXML private TextField topupTf;
    @FXML private Button topupBtn;
    
    @FXML
    private void initialize() {
        idTf.textProperty().addListener(
                (observable, oldText, newText) -> topupBtn.setDisable(newText.isEmpty())
        );
        
        topupTf.textProperty().addListener(
                (observable, oldText, newText) -> topupBtn.setDisable(newText.isEmpty())
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
    
    private int getTopup(){
        return Integer.parseInt(topupTf.getText());
    }
    
    private void setTopup(int amount){
        idTf.setText("" + amount);
    }
    
    private void setResult(String phrase){
        result.setText(phrase);
    }
    
    @FXML private void handleTopup(ActionEvent e) throws IOException{
        try{
            Customer customer = getKiosk().getCustomer(getId());
            if (getKiosk().getCustomer(getId()) != null) {
                //Customer customer = getKiosk().getCustomer(getId());
                if(getTopup() > 0){
                    getKiosk().topUpAccount(customer, getTopup());
                    setResult("Transaction complete.");
                }
                else{
                    setResult("Topup amount must be larger than 0.");
                }
            }
            else{
                setResult("Customer does not exist.");
            }
        }
        catch(Exception g){
            setResult("" + g);
        }
    }
    
    @FXML private void handleClose(ActionEvent e) throws IOException{
        stage.close();
    }
}
