package week8;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * Create JavaFX app that given weight of person on Earth, calculate the weight
 * of another person on the MOON, VENUS, MARS, JUPITER.
 * @author Hank Gontarz
 */
public class WeightOnPlanet extends Application {
    private static final double GRAVITY_MOON = 0.17;
    private static final double GRAVITY_VENUS = 0.91;
    private static final double GRAVITY_MARS = 0.38;
    private static final double GRAVITY_JUPITER = 2.54;
    
    private TextField tfEarth, tfMoon, tfVenus, tfMars, tfJupiter;
            
    @Override
    public void start(Stage primaryStage) {
        Label lbTitle = new Label("How Much Do I Weigh?");
        lbTitle.setStyle("-fx-font-size: 24pt; -fx-text-fill: #ff0000;");
        HBox hBoxTitle = new HBox();
        hBoxTitle.setAlignment(Pos.CENTER);
        hBoxTitle.getChildren().add(lbTitle);
        
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 20; -fx-alignment: center");
//## Earth
        Label lbEarth = new Label("Earth");
        lbEarth.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbEarth, 0, 0);
        tfEarth = new TextField();
        tfEarth.setPromptText("Enter your weight");
        gridPane.add(tfEarth, 1, 0);
//## Moon
        Label lbMoon = new Label("Moon");
        lbMoon.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbMoon, 0, 1);
        tfMoon = new TextField();
        tfMoon.setEditable(false);
        gridPane.add(tfMoon, 1, 1);
//## Venus
        Label lbVenus = new Label("Venus");
        lbVenus.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbVenus, 0, 2);
        tfVenus = new TextField();
        tfVenus.setEditable(false);
        gridPane.add(tfVenus, 1, 2);
//## Mars
        Label lbMars = new Label("Mars");
        lbMars.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbMars, 0, 3);
        tfMars = new TextField();
        tfMars.setEditable(false);
        gridPane.add(tfMars, 1, 3);
//## Jupiter
        Label lbJupiter = new Label("Jupiter");
        lbJupiter.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbJupiter, 0, 4);
        tfJupiter = new TextField();
        tfJupiter.setEditable(false);
        gridPane.add(tfJupiter, 1, 4);
//## Other controls
        Button btn = new Button();
        btn.setText("Calculate");
        btn.setStyle("-fx-font-size: 18pt; -fx-padding: 10; -fx-text-fill: #0000ff;");
        btn.setOnAction(e -> calculate());

        HBox hBoxButton = new HBox();
        hBoxButton.setAlignment(Pos.CENTER);
        hBoxButton.getChildren().add(btn);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-padding: 20");
        borderPane.setTop(hBoxTitle);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBoxButton);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Weight On Planets");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void calculate() {
        double weight = Double.parseDouble(tfEarth.getText());
        double moonWeight = weight * GRAVITY_MOON;
        double venusWeight = weight * GRAVITY_VENUS;
        double marsWeight = weight * GRAVITY_MARS;
        double jupiterWeight = weight * GRAVITY_JUPITER;
        
        tfMoon.setText(String.format("%.2f", moonWeight));
        tfVenus.setText(String.format("%.2f", venusWeight));
        tfMars.setText(String.format("%.2f", marsWeight));
        tfJupiter.setText(String.format("%.2f", jupiterWeight));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
