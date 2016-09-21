package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private DataBase _dataBase = DataBase.getInstance();
    private static Stage _primaryStage;



    // start method is the entry point for all javafx applications, launch calls start
    @Override
    public void start(Stage primaryStage) throws Exception{

        _primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("VOXSPELL");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    @Override
    public void stop() {
        System.out.println("stage is closing");

        try {
            _dataBase.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Stage getPrimaryStage() {
        return _primaryStage;
    }




    public static void main(String[] args) {

        launch(args);

    }
}
