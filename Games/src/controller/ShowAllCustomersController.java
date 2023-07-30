package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.Customer;
import model.Game;
import model.Kiosk;

public class ShowAllCustomersController extends Controller<Kiosk> {
    @FXML private TableView<Customer> allCustomersTv;
    
    public final Kiosk getKiosk(){
        return model;
    }
    
    @FXML private void closeWindow(ActionEvent e) throws IOException{
        stage.close();
    }

}
