package week8;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 55gontarhd03
 */
public class C16N01 extends Application {
    private double paneWidth = 500;
    private double paneHeight = 150;
    
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(20, 40, "Programming is fun");
        text.setFont(new Font("Times", 20));
        Pane pane = new Pane();
        pane.getChildren().add(text);
        pane.setStyle("-fx-border-color: gray");

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        
        ToggleGroup tgGroup = new ToggleGroup();
        rbRed.setToggleGroup(tgGroup);
        rbYellow.setToggleGroup(tgGroup);
        rbBlack.setToggleGroup(tgGroup);
        rbOrange.setToggleGroup(tgGroup);
        rbGreen.setToggleGroup(tgGroup);
        
        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-border-color: red; -fx-padding: 10 0 20 0");
        hBox.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        
        Button btLeft = new Button("<-");
        Button btRight = new Button("->");
        HBox hBoxButton = new HBox(10);
        hBoxButton.getChildren().addAll(btLeft, btRight);
        hBoxButton.setAlignment(Pos.CENTER);
        
        BorderPane bdPane = new BorderPane();
        bdPane.setTop(hBox);
        bdPane.setCenter(pane);
        bdPane.setBottom(hBoxButton);
        
        Scene scene = new Scene(bdPane, paneWidth, paneHeight);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        rbRed.setOnAction(e -> text.setStroke(Color.RED));
        rbYellow.setOnAction(e -> text.setStroke(Color.YELLOW));
        rbBlack.setOnAction(e -> text.setStroke(Color.BLACK));
        rbOrange.setOnAction(e -> text.setStroke(Color.ORANGE));
        rbGreen.setOnAction(e -> text.setStroke(Color.GREEN));
        btLeft.setOnAction(e -> text.setX(text.getX() - 5));
        btRight.setOnAction(e -> text.setX(text.getX() + 5));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
