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
 * javaFX controller class for the scene LevelFailed.fxml
 */
public class LevelFailedController implements Initializable {

    @FXML
    private Button nextLevel;

    /**
     * controls the logic for the retry level button, when pressed the scene switches to SpellingQuiz.fxml
     * @throws IOException
     */
    @FXML
    public void retryLevel() throws IOException {

        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("SpellingQuiz.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    /**
     * controls the logic for the return to main menu button, when pressed the scene switches to sample.fxml (our main menu)
     * @throws IOException
     */
    public void returnToMainMenu() throws IOException {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }


    /**
     * called when the scene is opened, makes sure to disable the next level button if on level 10
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Level.getCurrentlevel() >= 10) {
            nextLevel.setDisable(true);
        }
    }
}
