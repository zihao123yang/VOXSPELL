package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Created by zihao123yang on 19/09/16.
 */
public class SpellingQuizController {

    private Spelling_Logic _spellingLogic = new Spelling_Logic();

    @FXML
    private TextArea _display;

    @FXML
    private TextField _inputField;



    public void setDisplay(String text) {

        _display.setText(text);

    }


    public void userInput() {

        String answer = _inputField.getCharacters().toString();

        _spellingLogic.spellingQuiz(answer);
    }

}
