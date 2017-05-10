package chap0;

import java.awt.Color;
import phillips.turtle.TurtleDrawing;

/**
 * Draw Squares using a method with a parameter; (Make a house with methods)
 * 
 * @author Hank Gontarz
 */
public class P11House extends TurtleDrawing {

    public static void main(String[] args) {
        P11House t = new P11House();
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
    public void myHouse(int xHome, int yHome, int houseWidth, int windowWidth, int windowHeight, 
        int windowOffset, int doorWidth, int doorHeight, int stackHeight, Color houseColor) {
        
        setPenColor(Color.ORANGE);
        setXY(xHome + ((houseWidth * 20)/32), (yHome - stackHeight) - ((houseWidth * 2)/3)); 
        myRectangle(5, stackHeight); //stack
        
        setXY(xHome, yHome); //go home
        setPenColor(houseColor);
        myRectangle(houseWidth, houseWidth); //house
        myTriangle(houseWidth); //roof
        
        setPenColor(Color.BLUE);
        setXY(xHome + windowOffset, yHome + windowOffset); 
        myRectangle(windowWidth, windowHeight); //window1
        
        setXY((xHome + houseWidth) - (windowOffset + windowWidth), yHome + windowOffset); 
        myRectangle(windowWidth, windowHeight); //window2
        
        setPenColor(Color.RED);
        setXY(xHome + (houseWidth/2 - doorWidth/2), yHome + (houseWidth - doorHeight)); 
        myRectangle(doorWidth, doorHeight); //front door
    }
    @Override
    public void userDraw() {
        int  houseWidth = 120;
        int  windowWidth = 15;
        int  windowHeight = 25;
        int  windowOffset = 12;
        int  doorWidth = 20;
        int  doorHeight = 40;
        int  stackHeight = 50;
        
        say("P11House by Hank Gontarz");
        setDelay(-1);
        int xHome = this.getTurtleX();
        int yHome = this.getTurtleY();
        myHouse(xHome, yHome, houseWidth, windowWidth,
                windowHeight, windowOffset, doorWidth, doorHeight, stackHeight, Color.BLACK);
        myHouse(xHome+150, yHome, houseWidth, windowWidth,
                windowHeight, windowOffset, doorWidth, doorHeight, stackHeight, new Color(50, 255, 150));

        ht(); //hide turtle
        draw();
    }
}
