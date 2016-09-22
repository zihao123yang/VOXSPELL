package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by zihao123yang on 22/09/16.
 */
public class LevelFailedController implements Initializable {

    @FXML
    private Button nextLevel;

    @FXML
    public void retryLevel() throws IOException {

        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("SpellingQuiz.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void returnToMainMenu() throws IOException {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("sam ple.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void Statistics() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Level.getCurrentlevel() >= 10) {
            nextLevel.setDisable(true);
        }
    }
}