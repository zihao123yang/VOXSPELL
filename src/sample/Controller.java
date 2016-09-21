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
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private DataBase _dataBase = DataBase.getInstance();


    @FXML
    private Button button;


    @FXML
    public void goToSpelling() throws IOException {

        Stage stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("spellingQuizScene.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            _dataBase.loadFailed();
            _dataBase.loadStats();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        _dataBase.printSavedFIles();
    }
}
