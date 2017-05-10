package chap0;

import java.awt.Color;
import phillips.turtle.TurtleDrawing;

/**
 * Draw three squares with different colors and sizes.
 *
 * @author Hank Gontarz
 */
/* Various commands
    say("");
    forward(#); fd(#);
    backward(#); bk(#);
    right(#); rt(#);
    left(#); lt(#);
    setXY(x,y); //absolute
    setPenColor(RGB);
    setPenSize(#);
    penUp(); pu();
    penDown(); pd();
    drawLine(int distance);
    home();
    drawXY(int x2, int y2);
    circle(int r);
    filledCircle(int r);
    oval(int width, int height);
    filledOval(int width, int height);
    square(int width);
    filledSquare(int width);
    setTraceOn();
*/
public class P04ThreeSquares extends TurtleDrawing {

    public static void main(String[] args) {
        P04ThreeSquares t = new P04ThreeSquares();
        t.userDraw();
    }
    public void mySquare(int width) {
        for(int i = 1; i <= 4; i++) {
            fd(width);
            rt(90);
        }
    }
    
    @Override
    public void userDraw() {
        int numSquares = 3;     //The number of squares to draw
        int width = 50;         //The width of one square
        int offsetXY = 10;      //The gap offset from a neighboring box

        say("P04ThreeSquares by Hank Gontarz");
        setDelay(0);
        int xHome = getTurtleX();
        int yHome = getTurtleY();
        for(int i = 0; i < numSquares; i++) {
            switch(i) {
                case 0:
                    setPenColor(Color.RED);
                    filledSquare(width);
                    setPenColor(Color.GREEN);
                    setXY(xHome + (width/2), yHome + (width/2));
                    filledCircle(width);
                    break;
                case 1:
                    setPenColor(Color.ORANGE);
                    setXY(xHome - width - offsetXY, yHome - width - offsetXY);
                    mySquare(width);
                    break;
                case 2:
                    setPenColor(Color.BLUE);
                    setXY(xHome + width + offsetXY, yHome - width - offsetXY);
                    mySquare(width);
                    break;
                default:
                    if(numSquares >= 3) continue;
                    setPenColor(Color.BLACK);
                    setXY(xHome, yHome - width - offsetXY);
                    mySquare(width);
                    break;
            }
        }
        ht(); //hide turtle
    }
}
