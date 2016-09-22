package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by eli on 22/09/16.
 */
public class ClearStatisticsScene implements Initializable{

    DataBase _db = DataBase.getInstance();
    RevisionQuiz _rv = RevisionQuiz.getInstance();

    @FXML
    Label yesLabel;

    @FXML
    Label noLabel;

    @FXML
    Button mainMenuButton;

    @FXML
    Button yesButton;

    @FXML
    Button noButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yesLabel.setVisible(false);
        noLabel.setVisible(false);
        mainMenuButton.setVisible(false);
        mainMenuButton.disarm();
    }



    public void yesPressed(){
        yesLabel.setVisible(true);

        _db.clearStats();
        //_rv.clearFailed();

        yesButton.setVisible(false);
        noButton.setVisible(false);

        mainMenuButton.arm();
        mainMenuButton.setVisible(true);



    }

    public void noPressed(){

        noLabel.setVisible(true);


        yesButton.setVisible(false);
        noButton.setVisible(false);

        mainMenuButton.arm();
        mainMenuButton.setVisible(true);

    }

    public void mainMenuPressed() throws IOException{
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

}
