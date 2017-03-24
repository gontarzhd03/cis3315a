package week8;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author 55gontarhd03
 */
public class Life extends Application {
    int[][] cells = new int[100][100];
    Pane pane = new Pane();
    BorderPane brdPane = new BorderPane();
        
    @Override
    public void start(Stage primaryStage) {
        initCells();
        brdPane.setCenter(pane);
        drawCells();

        Button btn = new Button("Next Generation");
        btn.setOnAction((ActionEvent event) -> {
            nextGen();
            drawCells();
        });
        brdPane.setBottom(btn);
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);

        Scene scene = new Scene(brdPane, 1100, 1100);
        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void initCells() {
        for(int y = 0; y < 100; y++) {
            for(int x = 0; x < 100; x++) {
                cells[x][y] = Math.random() > 0.5 ? 0 : 1;
            }
        }
    }
    public void drawCells() {
        pane.getChildren().clear();
//        pane.setBackground(Background.);
        for(int y = 0; y < 100; y++) {
            for(int x = 0; x < 100; x++) {
                Rectangle rect = new Rectangle(x*10, y*10, 9, 9);
                rect.setFill(cells[x][y] == 0 ? Color.WHITE : Color.BLACK);
                pane.getChildren().add(rect);
            }
        }
    }
    public void nextGen() {
        int[][] cellsng = new int[100][100];
        
        for(int y = 0; y < 100; y++) {
            for(int x = 0; x < 100; x++) {
                int neighbors = 0;
                if(x > 1 && x < 99 && y > 1 && y < 99) {
                    if(cells[x-1][y-1] == 1) { //aboveleft
                        neighbors++;
                    }
                    if(cells[x][y-1] == 1) { //above
                        neighbors++;
                    }
                    if(cells[x + 1][y-1] == 1) { //aboveright
                        neighbors++;
                    }
                    if(cells[x-1][y] == 1) { //left
                        neighbors++;
                    }
                    if(cells[x + 1][y] == 1) { //right
                        neighbors++;
                    }
                    
                    if(cells[x-1][y+1] == 1) { //belowleft
                        neighbors++;
                    }
                    if(cells[x][y+1] == 1) { //below
                        neighbors++;
                    }
                    if(cells[x+1][y+1] == 1) { //belowright
                        neighbors++;
                    }
                    if(cells[x][y] == 1) {
                        if(neighbors < 2 || neighbors > 3) {
                            cellsng[x][y] = 0;
                        }
                        else {
                            cellsng[x][y] = 1;
                        }
                    }
                    else if(neighbors == 3) {
                        cellsng[x][y] = 1;
                    }
                }
                else {
                    cellsng[x][y] = 0;
                }
            }
        }
        cells = cellsng;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
