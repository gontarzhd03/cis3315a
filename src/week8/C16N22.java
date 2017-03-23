package week8;

import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
/**
 *
 * @author Hank Gontarz
 */
public class C16N22 extends Application {
    AudioClip audio = new AudioClip("http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3");
        
    @Override
    public void start(Stage primaryStage) {
        Button btPlay = new Button("Play");
        Button btLoop = new Button("Loop");
        Button btStop = new Button("Stop");
        
        HBox hBoxButtons = new HBox(10);
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.getChildren().addAll(btPlay, btLoop, btStop);

        btPlay.setOnAction((ActionEvent event) -> {
            audio.setCycleCount(1);
            audio.play();
        });
        btLoop.setOnAction((ActionEvent event) -> {
            audio.setCycleCount(Timeline.INDEFINITE);
            audio.play();
        });
        btStop.setOnAction((ActionEvent event) -> {
            audio.stop();
        });
        Scene scene = new Scene(hBoxButtons, 200, 100);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
