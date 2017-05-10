package chap0;

import java.awt.Color;
import phillips.turtle.TurtleDrawing;

/**
 * Draw 5 different colored crayons
 * 
 * @author Hank Gontarz
 */
public class P12FiveCrayons extends TurtleDrawing {

    public static void main(String[] args) {
        P12FiveCrayons t = new P12FiveCrayons();
        t.userDraw();
    }
    public void myTriangle(int width) {
        fd(width);
        lt(120);
        fd(width);
        lt(120);
        fd(width);
        lt(120);
    }
    public void myRectangle(int width, int height) {
//square
        fd(width);
        rt(90);
        fd(height);
        rt(90);
        fd(width);
        rt(90);
        fd(height);
        rt(90);
    }
    public void myHouse(int xHome, int yHome, int houseWidth, int houseHeight, int windowWidth, int windowHeight, 
        int windowOffset, int doorWidth, int doorHeight, int stackHeight, Color houseColor) {
        
        setXY(xHome, yHome); //go home
        setPenColor(houseColor);
        myRectangle(houseWidth, houseHeight); //house
        myTriangle(houseWidth); //roof
    }
    @Override
    public void userDraw() {
        int  houseWidth = 40;
        int  houseHeight = 200;
        int  windowWidth = 0;
        int  windowHeight = 0;
        int  windowOffset = 0;
        int  doorWidth = 0;
        int  doorHeight = 0;
        int  stackHeight = 0;
        
        say("P12FiveCrayons by Hank Gontarz");
        setDelay(0);
        int xHome = getTurtleX();
        xHome -= 200;
        int yHome = getTurtleY();
        
        myHouse(xHome, yHome, houseWidth, houseHeight, windowWidth,
                windowHeight, windowOffset, doorWidth, doorHeight, stackHeight, Color.BLUE);

        myHouse(xHome+50, yHome, houseWidth, houseHeight, windowWidth,
                windowHeight, windowOffset, doorWidth, doorHeight, stackHeight, Color.GREEN);
        
        myHouse(xHome+100, yHome, houseWidth, houseHeight, windowWidth,
                windowHeight, windowOffset, doorWidth, doorHeight, stackHeight, Color.RED);
        
        myHouse(xHome+150, yHome, houseWidth, houseHeight, windowWidth,
                windowHeight, windowOffset, doorWidth, doorHeight, stackHeight, Color.YELLOW);
        
        myHouse(xHome+200, yHome, houseWidth, houseHeight, windowWidth,
                windowHeight, windowOffset, doorWidth, doorHeight, stackHeight, Color.MAGENTA);
        ht(); //hide turtle
    }
}
