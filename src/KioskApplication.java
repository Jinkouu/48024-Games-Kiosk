import au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import javafx.application.Application;
import model.Kiosk;

public class KioskApplication extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewLoader.showStage(new Kiosk(), "/view/Kiosk.fxml", "Game Kiosk - Main Menu", stage);
        
    }
}
