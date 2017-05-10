package chap0;

import java.awt.Color;
import java.util.Random;
import phillips.turtle.TurtleDrawing;

/**
 * Draw 20 houses in random locations, size & color
 * 
 * @author Hank Gontarz
 */
public class P16RandomHouses extends TurtleDrawing {
    Random rand = new Random();
    
    public static void main(String[] args) {
        P16RandomHouses t = new P16RandomHouses();
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
        int windowOffset, int doorWidth, int doorHeight, Color houseColor) {
        
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
        int  houseWidth = 100;
        int  windowWidth = 15;
        int  windowHeight = 25;
        int  windowOffset = 12;
        int  doorWidth = 20;
        int  doorHeight = 40;
        int  xHome = 0;
        int  yHome = 0;
        
        say("P16RandomHouses by Hank Gontarz");
        setDelay(0);
        for(int i = 1; i <= 20; i++) {
            houseWidth = rand.nextInt(200) + 50;
            xHome = rand.nextInt(PANEL_WIDTH - 10);
            yHome = rand.nextInt(PANEL_HEIGHT - 10);
            myHouse(xHome, yHome, houseWidth, windowWidth, windowHeight, 
                    windowOffset, doorWidth, doorHeight, 
                    new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        }
        ht(); //hide turtle
    }
}
