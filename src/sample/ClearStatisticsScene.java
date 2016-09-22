package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yesLabel.setVisible(false);
        noLabel.setVisible(false);
    }



    public void yesPressed(){
        yesLabel.setVisible(true);
        _db.clearStats();
        //_rv.clearFailed();



    }

    public void noPressed(){
        noLabel.setVisible(true);

    }

}
