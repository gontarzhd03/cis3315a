package week6;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Hank Gontarz
 */
public class C14N03 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Integer> list = new ArrayList();
        
        for(int i = 1; i <= 52; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);
        HBox pane = new HBox(5);
//        VBox pane = new VBox(5);
        for(int i = 0; i < 5; i++) {
            pane.getChildren().add(new ImageView("image/card/" + list.get(i) + ".png"));
        }

        Scene scene = new Scene(pane, 500, 250);
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
