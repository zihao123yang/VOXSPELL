package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private TextField _inputField;

    @FXML
    private Button _submitButton;


    @FXML
    public void userInput() {

        String answer = _inputField.getCharacters().toString();

        _spellingLogic.spellingQuiz(answer);
    }

    @FXML
    public void submitButtonPressed() {

       String userInput = _inputField.getText();

        _spellingLogic.spellingQuiz(userInput);


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        _spellingLogic.setUpQuiz(true);
        _spellingLogic.spellingQuiz("");

        System.out.println(Level.getCurrentlevel());
    }


}
