package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.Customer;
import model.Kiosk;

public class RemoveCustomerController extends Controller<Kiosk> {
    @FXML private TableView<Customer> allCustomersTv;
    
    @FXML
    private void initialize() {
        //allCustomersTv.getSelectionModel().getSelectedItem().addListener();
    }
    
    public final Kiosk getKiosk(){
        return model;
    }
    
    private Customer getSelectedCustomer(){
        return allCustomersTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void removeCustomer(ActionEvent e) throws IOException{
        Customer customer = getSelectedCustomer();
        getKiosk().removeCustomer(customer);
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }
}
