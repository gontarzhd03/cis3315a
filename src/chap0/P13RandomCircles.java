package chap0;

import java.awt.Color;
import java.util.Random;
import phillips.turtle.TurtleDrawing;

/**
 * Draw random circles on screen
 * 
 * @author Hank Gontarz
 */
public class P13RandomCircles extends TurtleDrawing {

    Random rand = new Random();
    
    public static void main(String[] args) {
        P13RandomCircles t = new P13RandomCircles();
        t.userDraw();
    }

    @Override
    public void userDraw() {
        say("P13RandomCircles by Hank Gontarz");
        setDelay(0);
        setXY(rand.nextInt(PANEL_WIDTH), rand.nextInt(PANEL_HEIGHT));
        setPenColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        filledCircle(rand.nextInt(500) + 10);
        ht(); //hide turtle
    }
}
