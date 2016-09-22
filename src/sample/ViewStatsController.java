package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by eli on 22/09/16.
 */
public class ViewStatsController implements Initializable {

    @FXML
    TextArea statsDisplay;

    @FXML
    Button Button1;

    @FXML
    Button Button2;

    @FXML
    Button Button3;

    @FXML
    Button Button4;

    @FXML
    Button Button5;

    @FXML
    Button Button6;

    @FXML
    Button Button7;

    @FXML
    Button Button8;

    @FXML
    Button Button9;

    @FXML
    Button Button10;

    ArrayList<Button> levelButtons = new ArrayList<Button>();

    DisplayingStats _statistics = new DisplayingStats();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addButtons();
        statsDisplay.setText(_statistics.printStatistics(1));

    }

    public void addButtons(){
        levelButtons.addAll(Arrays.asList(Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9, Button10));
    }

    @FXML
    public void level1Pressed(){
        statsDisplay.setText(_statistics.printStatistics(1));
    }

    @FXML
    public void level2Pressed(){
        statsDisplay.setText(_statistics.printStatistics(2));
    }

    @FXML
    public void level3Pressed(){
        statsDisplay.setText(_statistics.printStatistics(3));
    }

    @FXML
    public void level4Pressed(){
        statsDisplay.setText(_statistics.printStatistics(4));
    }

    @FXML
    public void level5Pressed(){
        statsDisplay.setText(_statistics.printStatistics(5));
    }

    @FXML
    public void level6Pressed(){
        statsDisplay.setText(_statistics.printStatistics(6));
    }

    @FXML
    public void level7Pressed(){
        statsDisplay.setText(_statistics.printStatistics(7));
    }

    @FXML
    public void level8Pressed(){
        statsDisplay.setText(_statistics.printStatistics(8));
    }

    @FXML
    public void level9Pressed(){
        statsDisplay.setText(_statistics.printStatistics(9));
    }

    @FXML
    public void level10Pressed(){
        statsDisplay.setText(_statistics.printStatistics(10));
    }
}
