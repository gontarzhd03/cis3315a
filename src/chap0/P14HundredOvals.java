package chap0;

import java.awt.Color;
import java.util.Random;
import phillips.turtle.TurtleDrawing;

/**
 * Draw various random ovals on screen
 * 
 * @author Hank Gontarz
 */
public class P14HundredOvals extends TurtleDrawing {

    Random rand = new Random();
    
    public static void main(String[] args) {
        P14HundredOvals t = new P14HundredOvals();
        t.userDraw();
    }
    public void myOval() {
        setXY(rand.nextInt(PANEL_WIDTH), rand.nextInt(PANEL_HEIGHT));
        setPenColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        filledOval(rand.nextInt(500) + 10, rand.nextInt(500) + 10);
    }
    @Override
    public void userDraw() {
        say("P14HundredOvals by Hank Gontarz");
        setDelay(0);
        for(int i = 1; i <= 100; i++) {
            myOval();
        }
        ht(); //hide turtle
    }
}
