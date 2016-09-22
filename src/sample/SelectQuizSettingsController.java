package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by eli on 21/09/16.
 * Controls the logic for the scene after the 'New Quiz button' or 'Review  Quiz button' is selected
 */
public class SelectQuizSettingsController implements Initializable {

    @FXML
    ToggleButton level1;

    @FXML
    ToggleButton level2;

    @FXML
    ToggleButton level3;

    @FXML
    ToggleButton level4;

    @FXML
    ToggleButton level5;

    @FXML
    ToggleButton level6;

    @FXML
    ToggleButton level7;

    @FXML
    ToggleButton level8;

    @FXML
    ToggleButton level9;

    @FXML
    ToggleButton level10;

    @FXML
    private ComboBox voiceChoiceBox;

    ObservableList<String> voiceList = FXCollections.observableArrayList("voice_kal_diphone", "voice_akl_nz_jdt_diphone");

    @FXML
    public void level1Pressed(ActionEvent event) {
        Level.setLevel(1);
    }

    @FXML
    public void level2Pressed() {
        Level.setLevel(2);
    }

    @FXML
    public void level3Pressed() {
        Level.setLevel(3);
    }

    @FXML
    public void level4Pressed() {
        Level.setLevel(4);
    }

    @FXML
    public void level5Pressed() {
        Level.setLevel(5);
    }

    @FXML
    public void level6Pressed() {
        Level.setLevel(6);
    }

    @FXML
    public void level7Pressed() {
        Level.setLevel(7);
    }

    @FXML
    public void level8Pressed() {
        Level.setLevel(8);
    }

    @FXML
    public void level9Pressed() {
        Level.setLevel(9);
    }

    @FXML
    public void level10Pressed() {
        Level.setLevel(10);
    }

    @FXML
    public void continueToQuiz() throws IOException {

        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("SpellingQuiz.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    public void returnToMainMenu() throws IOException {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    public void voiceChanging() {
        if (voiceChoiceBox.getValue().equals("voice_kal_diphone")) {
            Festival.setVoice("(voice_kal_diphone)");
        } else if (voiceChoiceBox.getValue().equals("voice_akl_nz_jdt_diphone")) {
            Festival.setVoice("(voice_akl_nz_jdt_diphone)");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        voiceChoiceBox.setValue("voice_kal_diphone");
        voiceChoiceBox.setItems(voiceList);

    }
}
