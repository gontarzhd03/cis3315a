package week8;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
/**
 *
 * @author Hank Gontarz
 */
public class C16N24 extends Application {
    MediaPlayer mp = new MediaPlayer(
            new Media("http://www.cs.armstrong.edu/liang/common/sample.mp4"));
        
    @Override
    public void start(Stage primaryStage) {
        MediaView mv = new MediaView(mp);
        Button btPlay = new Button("Play");
        Button btPause = new Button("Pause");
        Button btStop = new Button("Stop");
        
        HBox hBoxButtons = new HBox(10);
        hBoxButtons.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 10; -fx-alignment: center");
        hBoxButtons.getChildren().addAll(btPlay, btPause, btStop);

        btPlay.setOnAction((ActionEvent event) -> {
            mp.play();
        });
        btPause.setOnAction((ActionEvent event) -> {
            mp.pause();
        });
        btStop.setOnAction((ActionEvent event) -> {
            mp.stop();
        });
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(mv);
        borderPane.setBottom(hBoxButtons);
        
        Scene scene = new Scene(borderPane, 750, 550);
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
