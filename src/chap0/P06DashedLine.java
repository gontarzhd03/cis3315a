package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Draw using penUp() & penDown() to make a dashed line
 * 
 * @author Hank Gontarz
 */
public class P06DashedLine extends TurtleDrawing {

    public static void main(String[] args) {
        P06DashedLine t = new P06DashedLine();
        t.userDraw();
    }
    
    public void dashedLine(int boxWidth, int dashOffLen, int dashOnLen) {
        int segments = 0;
        
        segments = boxWidth;
        while(segments > 0) {
            pd();
            fd(dashOnLen);
            pu();
            fd(dashOffLen);
            pd();
            segments -= (dashOffLen + dashOnLen);
        }
    }
    
    public void oneSquare(int boxWidth, int dashOffLen, int dashOnLen) {
        for(int i = 1; i <= 4; i++) {
            dashedLine(boxWidth, dashOffLen, dashOnLen);
            rt(90);
        }
    }
    
    @Override
    public void userDraw() {
        int numSquares = 2;         //The number of steps to make
        int offsetStairsX = 100;    //The X offset to adjust
        int offsetStairsY = -200;    //The Y offset to adjust
        int offsetXY = 10;          //The gap offset from a neighboring box
        int boxWidth = 100;         //The width of one square
        int dashOffLen = 5;         //The length of the penup dash
        int dashOnLen = 10;         //The length of the pendown dash

        say("P06DashedLine by Hank Gontarz");
        setDelay(0);
        int xHome = getTurtleX();
        int yHome = getTurtleY();
        setXY(xHome - offsetStairsX, yHome + offsetStairsY);
        for(int i = 0; i < numSquares; i++) {
            oneSquare(boxWidth, dashOffLen, dashOnLen);
            setXY(getTurtleX() + boxWidth + offsetXY, getTurtleY() + boxWidth + offsetXY);
        }
        ht(); //hide turtle
    }
}
