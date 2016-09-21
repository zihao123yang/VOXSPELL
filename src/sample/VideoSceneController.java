package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by zihao123yang on 22/09/16.
 */
public class VideoSceneController implements Initializable {


    @FXML
    private MediaView mediaView;

    private MediaPlayer mediaPlayer;

    private Media media;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String path = new File("big_buck_bunny_1_minute.mp4").getAbsolutePath();

        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);

        DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

    }
}
