package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * a simple javaFX program which acts as a spelling aid
 */
public class Main extends Application {

    private DataBase _dataBase = DataBase.getInstance();
    private static Stage _primaryStage;

    private RevisionQuiz _revisionData = RevisionQuiz.getInstance();


    /**
     * loads the primary stage sample.fxml which acts as the main menu
     * populates the database
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            _revisionData.loadFailed();
            _dataBase.loadStats();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        _primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("VOXSPELL");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * called when application is closed, saving statistics to database
     */
    @Override
    public void stop() {


        try {
            _dataBase.saveStats();
            _revisionData.saveFailed();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * returns the primary stage
     * @return
     */
    public static Stage getPrimaryStage() {

        return _primaryStage;
    }




    public static void main(String[] args) {

        launch(args);

    }
}
