package week6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Hank Gontarz
 */
public class C14N01 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(25);
        pane.setVgap(25);

        ImageView vw1 = new ImageView("image/uk.gif");
        ImageView vw2 = new ImageView("image/ca.gif");
        ImageView vw3 = new ImageView("image/china.gif");
        ImageView vw4 = new ImageView("image/us.gif");
        pane.add(vw1, 0, 0);
        pane.add(vw2, 1, 0);
        pane.add(vw3, 0, 1);
        pane.add(vw4, 1, 1);
        Scene scene = new Scene(pane, 400, 400);
        
        primaryStage.setTitle("C14N01");
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
