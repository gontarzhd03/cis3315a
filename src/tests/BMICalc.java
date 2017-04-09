package bmi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Create a Java FX application that calculates the body mass index (BMI) given
 * a person's weight in pounds and height in inches. The formula is
 *
 * BMI = 703 * weight / height^2
 *
 * Also print the BMI weight range result where
 *
 * Underweight: BMI is less than 18.5 Normal weight: BMI is 18.5 to 24.9
 * Overweight: BMI is 25 to 29.9 Obese: BMI is 30 or more
 *
 * See the attached image for the screen design.
 *
 * @author Hank Gontarz
 */
public class BMICalc extends Application {

    TextField tfWeight, tfHeight, tfBMI, tfResult;

    @Override
    public void start(Stage primaryStage) {

        // Change the title to include your name
        Label lbTitle = new Label("Hank's BMI Calculator");        
        lbTitle.setStyle(" -fx-font-size: 24pt; -fx-text-fill: #00cc00;");
        HBox hBoxTitle = new HBox();
        hBoxTitle.setAlignment(Pos.CENTER);
        hBoxTitle.getChildren().add(lbTitle);

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 20; -fx-alignment: center;");

        Label lbWeight = new Label("Weight in Pounds");
        lbWeight.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbWeight, 0, 0);
        tfWeight = new TextField();
        gridPane.add(tfWeight, 1, 0);

        // insert code for height
        Label lbHeight = new Label("Height in Inches");
        lbHeight.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbHeight, 0, 1);
        tfHeight = new TextField();
        gridPane.add(tfHeight, 1, 1);
        
        
        Label lbBMI = new Label("BMI");
        lbBMI.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbBMI, 0, 2);
        tfBMI = new TextField();
        tfBMI.setEditable(false);
        gridPane.add(tfBMI, 1, 2);

        Label lbResult = new Label("Result");
        lbResult.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbResult, 0, 3);
        tfResult = new TextField();
        tfResult.setEditable(false);
        gridPane.add(tfResult, 1, 3);

        Button btn = new Button();
        btn.setText("Calculate");
        btn.setStyle("-fx-font-size: 18pt; -fx-padding: 10; -fx-text-fill: #0000ff;");
        btn.setOnAction((ActionEvent e) -> calculate());

        HBox hBoxBtn = new HBox();
        hBoxBtn.setAlignment(Pos.CENTER);
        hBoxBtn.getChildren().add(btn);

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-padding: 20;");
        borderPane.setTop(hBoxTitle);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBoxBtn);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Calculator!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//BMI = 703 * weight / height^2
    private void calculate() {
        String result = "";
        // implement the calculate method
        double weight = Integer.parseInt(tfWeight.getText());
        double height = Integer.parseInt(tfHeight.getText());
        double bmi = ((703 * weight) / (height * height));
        tfBMI.setText(String.format("%.1f", bmi));
        if(bmi < 18.5) {
            result = "Underweight";
        }
        else if(bmi >= 18.5 && bmi <= 24.9) {
            result = "Normal weight";
        }
        else if(bmi >= 25 && bmi <= 29.9) {
            result = "Overweight";
        }
        else if(bmi >= 30) {
            result = "Obese";
        }
        tfResult.setText(result);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
