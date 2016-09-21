package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by zihao123yang on 22/09/16.
 */
public class LevelCompletedController {

    @FXML
    public void returnToMainMenu() throws IOException {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("sanple.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    public void retryLevel() throws IOException {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("SpellingQuiz.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    public void nextLevel() throws IOException {
        Level.nextLevel();
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("SpellingQuiz.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
