package week7;

import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 *
 * @author Hank Gontarz
 */
public class C15N02 extends Application {
    int CurrentRotate = 0;
    
    @Override
    public void start(Stage primaryStage) {
        Rectangle rg;
            
        HBox hbox1 = new HBox(0);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setPadding(new Insets(100,0,10,10));
        rg = new Rectangle(100, 50, 100, 30);
        rg.setStroke(Color.BLACK);
        rg.setFill(Color.WHITE);
        hbox1.getChildren().add(rg);
        
        Button btn = new Button();
        btn.setText("Rotate");
        btn.setOnAction((ActionEvent event) -> {
            hbox1.getChildren().clear();
            CurrentRotate += 15;
            Rectangle rg2 = new Rectangle(100, 50, 100, 30);
            rg2.setStroke(Color.BLACK);
            rg2.setFill(Color.WHITE);
            rg2.setRotate(CurrentRotate);
            hbox1.getChildren().add(rg2);
        });
        HBox hbox2 = new HBox(5);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().add(btn);
        hbox2.setPadding(new Insets(5,5,20,5));
        
        BorderPane pane = new BorderPane();
        pane.setTop(hbox1);
        pane.setBottom(hbox2);
        
        
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
