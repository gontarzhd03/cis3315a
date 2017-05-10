package chap0;

import java.awt.Color;
import phillips.turtle.TurtleDrawing;

/**
 * Draw a chess board on the screen.
 * 
 * @author Hank Gontarz
 */
public class P18ChessBoard extends TurtleDrawing {

    public static void main(String[] args) {
        P18ChessBoard t = new P18ChessBoard();
        t.userDraw();
    }
    public void drawChessBoard1() { //8x8 board
        Color rectColor = Color.BLACK;
        int rectWidth = PANEL_WIDTH / 8;
        int rectHeight = PANEL_HEIGHT / 8;
        int rectPosX = 0;
        int rectPosY = 0;

        for(int row = 1; row <= 8; row++) {  //each row
            for(int col = 1; col <= 8; col++) {  //each column
                if(rectColor == Color.WHITE) {
                    rectColor = Color.BLACK;
                }
                else {
                    rectColor = Color.WHITE;
                }
                setPenColor(rectColor);
                setXY(rectPosX, rectPosY);
                filledRectangle(rectWidth, rectHeight);
                rectPosX += rectWidth;
            }
            rectPosX = 0;
            rectPosY += rectHeight;
            if(rectColor == Color.WHITE) {  //oscillate row color
                rectColor = Color.BLACK;
            }
            else {
                rectColor = Color.WHITE;
            }
        }
    }
    public void drawChessBoard2() { //8x8 board
        int rectWidth = PANEL_WIDTH / 8;
        int rectHeight = PANEL_HEIGHT / 8;

        for(int row = 0; row < 8; row++) {  //each row
            for(int col = 0; col < 8; col++) {  //each column
                if((col + row) % 2 == 0) {
                    setPenColor(Color.WHITE);
                }
                else {
                    setPenColor(Color.BLACK);
                }
                setXY((col * rectWidth), (row * rectHeight));
                filledRectangle(rectWidth, rectHeight);
            }
        }
    }
    @Override
    public void userDraw() {
        say("P18ChessBoard by Hank Gontarz");
        setDelay(0);
//        drawChessBoard1();
        drawChessBoard2();
        ht(); //hide turtle
    }
}
