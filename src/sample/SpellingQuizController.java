package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by zihao123yang on 19/09/16.
 */
public class SpellingQuizController implements Initializable {

    private Spelling_Logic _spellingLogic = new Spelling_Logic();



    @FXML
    private ComboBox selectVoice;


    @FXML
    private TextField _inputField;

    @FXML
    private Button _submitButton;


    ObservableList<String> voiceList = FXCollections.observableArrayList("voice_kal_diphone", "voice_akl_nz_jdt_diphone");

    @FXML
    public void userInput() {

        String answer = _inputField.getCharacters().toString();
        _inputField.clear();

        _spellingLogic.spellingQuiz(answer);
    }

    @FXML
    public void textFieldClicked() {
        _inputField.clear();
    }


    @FXML
    public void submitButtonPressed() {

       String userInput = _inputField.getText();
        _inputField.clear();

        _spellingLogic.spellingQuiz(userInput);

    }

    @FXML
    public void repeatWordPressed() {
        Festival.callFestival(_spellingLogic.currentWord());
    }

    @FXML
    public void voiceChanging() {
        if (selectVoice.getValue().equals("voice_kal_diphone")) {
            Festival.setVoice("voice_kal_diphone");
        } else if (selectVoice.getValue().equals("voice_akl_nz_jdt_diphone")) {
            Festival.setVoice("voice_akl_nz_jdt_diphone");
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectVoice.setValue(Festival.voice());
        selectVoice.setItems(voiceList);

        _spellingLogic.setUpQuiz();
        _spellingLogic.spellingQuiz("");



    }


}
