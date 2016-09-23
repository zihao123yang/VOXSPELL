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


    Statistics _stats = new Statistics();


    private Spelling_Logic _spellingLogic = new Spelling_Logic(_stats);


    @FXML
    private Text _levelAccuracyText;

    @FXML
    private Text _testAccuracyText;

    @FXML
    private Text _levelText;

    @FXML
    private ComboBox selectVoice;


    @FXML
    private TextField _inputField;

    @FXML
    private Button _submitButton;


    ObservableList<String> voiceList = FXCollections.observableArrayList("voice_kal_diphone", "voice_akl_nz_jdt_diphone");

   // @FXML
    //public void userInput() {


       // String answer = _inputField.getCharacters().toString();
//        _inputField.clear();



  //     _spellingLogic.spellingQuiz(answer);
    //    _testAccuracyText.setText("TEST ACCURACY: " +  _stats.calculateAccurracy());
    //}

    @FXML
    public void textFieldClicked() {
        _inputField.clear();
    }


    @FXML
    public void submitButtonPressed() {

       String userInput = _inputField.getText();
        _inputField.clear();

        int iteration = _spellingLogic.whichIteration();

        if(iteration == 1) {        // mastered, ...

            if (_spellingLogic.spellingCorrect(userInput)) {

                _stats.increaseMastered();
                System.out.println();
                System.out.println("num mastered: " + _stats._mastered);
                System.out.println();
                System.out.println("words tested: " + _stats._wordsTested);
                System.out.println();
                _testAccuracyText.setText("TEST ACCURACY: " +  _stats.calculateAccurracy() + "%");
                _levelAccuracyText.setText("LEVEL ACCURACY: " + _stats.calculateAccurracy() + "%");
                //-------------------------------------------------------------------
            } else {
                //----------------------------------------
            }

        } else if (iteration == 2) {    //faulted, failed

            if (_spellingLogic.spellingCorrect(userInput)) {
                _stats.increaseFaulted();
                _testAccuracyText.setText("TEST ACCURACY: " +  _stats.calculateAccurracy() + "%");
                _levelAccuracyText.setText("LEVEL ACCURACY: " + _stats.calculateAccurracy() + "%");

            } else {
                _stats.increaseFailed();
            }
            System.out.println();
            System.out.println("num mastered: " + _stats._mastered);
            System.out.println();
            System.out.println("words tested: " + _stats._wordsTested);
            System.out.println();
            _testAccuracyText.setText("TEST ACCURACY: " +  _stats.calculateAccurracy() + "%");
            _levelAccuracyText.setText("LEVEL ACCURACY: " + _stats.calculateAccurracy() + "%");
        }



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

        System.out.println(Level.getCurrentlevel());

        _levelText.setText("SPELLING QUIZ LEVEL: " +  Level.getCurrentlevel());
        _testAccuracyText.setText("TEST ACCURACY: 100.0%");
        _levelAccuracyText.setText("LEVEL ACCURACY: " + _stats.calculateAccurracy() + "%");




    }


}
