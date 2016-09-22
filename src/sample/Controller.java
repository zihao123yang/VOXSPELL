package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private DataBase _dataBase = DataBase.getInstance();
    private RevisionQuiz _revisionData = RevisionQuiz.getInstance();


    @FXML
    private Pane newQuizButton;


    @FXML
    public void newSpellingQuizClicked() throws IOException {

        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("SelectQuizSettings.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void reviewQuizClicked() throws IOException {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("RevisionSettings.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();



        _revisionData.printfailed2();

    }

    public void viewStatisticsClicked() {

    }

    public void clearStatisticsClicked() {
        _dataBase.clearStats();
        _revisionData.clearFailed();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        _dataBase.printSavedFIles();
    }
}
