package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class Controller {

    private Spelling_Logic _spellingLogic = new Spelling_Logic();


    @FXML
    private Button button;


    @FXML
    public void goToSpelling() throws IOException {




        Stage stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("spellingQuizScene.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();


    }




}
