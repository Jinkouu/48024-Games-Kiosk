
package controller;

import au.edu.uts.ap.javafx.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

public class AddCustomerController extends Controller<Kiosk>{//extends controller.KioskController{
    
    @FXML private Button closeBtn;
    @FXML private Button AddCustomerBtn;
    @FXML private TextField idTf;
    @FXML private TextField nameTf;
    @FXML private TextField balanceTf;
    @FXML private Text resultTxt;
    
    @FXML
     public void initialize() {
        //setId();
        //setName("");
        //setBalance();
    }
    
    private void setId(int id){ idTf.setText("" + id); }
    private int getID(){ return Integer.parseInt(idTf.getText()); }
    
    private void setName(String name){ nameTf.setText(name); }
    private String getName(){ return nameTf.getText(); }
    
    private void setBalance(int balance){ balanceTf.setText("" + balance); }
    private int getBalance(){ return Integer.parseInt(balanceTf.getText()); }
    
    private void setResult(String result){ resultTxt.setText(result); }
    
    private final Kiosk getKiosk(){ return model; }
    
    @FXML 
    private void handleAddCustomer(ActionEvent e) throws Exception{
        try{
            if(getKiosk().getCustomer(getID()) == null){
                if(getBalance() > 0){
                    getKiosk().addCustomer(getID(), getName(), getBalance());
                    setResult("Customer added to kiosk.");
                }
                else{
                    setResult("Topup amount must be larger than 0.");
                }
            }
            else {
                setResult("Customer already exists.");
            } 
        }
        catch(Exception g){
            setResult("" + g);
        }
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }
}
