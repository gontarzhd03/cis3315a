package week8;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author 55gontarhd03
 */
public class Life2 extends Application {
    int iteration = 0;
    int xCellCount = 100;
    int yCellCount = 50;
    int CELLWIDTH = 10;
    int CELLHEIGHT = 10;
    int CELLFILLWIDTH = 9;
    int CELLFILLHEIGHT = 9;
    
    int[][] cells = new int[xCellCount][yCellCount];
    Pane pane = new Pane();
    BorderPane brdPane = new BorderPane();
    Button btInit, btPause, btSlower, btFaster;
    Timeline animation;

    
    @Override
    public void start(Stage primaryStage) {
        brdPane.setCenter(pane);

        btInit = new Button("Initialize");
        btInit.setOnAction((ActionEvent event) -> {
            initCells();
            drawCells();
        });
        btPause = new Button("Pause");
        btPause.setOnAction((ActionEvent event) -> {
            if(btPause.getText().equals("Pause")) {
                btPause.setText("Play");
                pause();
            }
            else {
                btPause.setText("Pause");
                play();
            }
        });
        btSlower = new Button("Slower");
        btSlower.setOnAction((ActionEvent event) -> {
            slower();
        });
        btFaster = new Button("Faster");
        btFaster.setOnAction((ActionEvent event) -> {
            faster();
        });
        HBox btBox = new HBox(15);
        btBox.setAlignment(Pos.CENTER);
        btBox.setPadding(new Insets(5,0,5,0));
        btBox.getChildren().addAll(btInit, btPause, btSlower, btFaster);
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            nextGen();
            drawCells();
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        initCells();
        drawCells();
        
        brdPane.setBottom(btBox);

        Scene scene = new Scene(brdPane);
        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
        play();
    }
    public void play() {
        animation.play();
    }
    public void pause() {
        animation.pause();
    }
    public void slower() {
        animation.setRate(animation.getRate() + 2.0);
    }
    public void faster() {
        animation.setRate(animation.getRate() - 2.0);
    }
    public void initCells() {
        for(int y = 0; y < yCellCount; y++) {
            for(int x = 0; x < xCellCount; x++) {
                cells[x][y] = Math.random() > 0.5 ? 0 : 1;
            }
        }
    }
    public void drawCells() {
        pane.getChildren().clear();
//        pane.setBackground(Background.);
        for(int y = 0; y < yCellCount; y++) {
            for(int x = 0; x < xCellCount; x++) {
                Rectangle rect = new Rectangle(x*CELLWIDTH, y*CELLHEIGHT, CELLFILLWIDTH, CELLFILLHEIGHT);
                rect.setFill(cells[x][y] == 0 ? Color.WHITE : Color.BLACK);
                pane.getChildren().add(rect);
            }
        }
    }
    public void nextGen() {
        int[][] cellsng = new int[xCellCount][yCellCount];
        
        for(int y = 0; y < yCellCount; y++) {
            for(int x = 0; x < xCellCount; x++) {
                int neighbors = 0;
                if(x > 1 && x < xCellCount-1 && y > 1 && y < yCellCount-1) {
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
