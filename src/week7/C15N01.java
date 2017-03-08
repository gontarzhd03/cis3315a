package week7;

import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.Stage;

/**
 *
 * @author Hank Gontarz
 */
public class C15N01 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 1; i <= 52; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        HBox hbox = new HBox(-25);
        hbox.setAlignment(Pos.CENTER);
        for(int i = 0; i < 5; i++) {
            hbox.getChildren().add(new ImageView("image/card/" + list.get(i) + ".png"));
        }
        Button btRefresh = new Button("Refresh");
        btRefresh.setOnAction((ActionEvent event) -> {
            Collections.shuffle(list);
            hbox.getChildren().clear();
            for(int i = 0; i < 5; i++) {
                hbox.getChildren().add(new ImageView("image/card/" + list.get(i) + ".png"));
            }
        });
        HBox hbox2 = new HBox(5);
        hbox2.getChildren().add(btRefresh);
        hbox2.setPadding(new Insets(5,5,20,5));
        BorderPane pane = new BorderPane();
        pane.setCenter(hbox);
        pane.setBottom(hbox2);
        hbox2.setAlignment(Pos.CENTER);
        
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
