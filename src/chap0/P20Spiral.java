package chap0;

import java.awt.Color;
import java.util.Random;
import phillips.turtle.TurtleDrawing;

/**
 * Draw a spiral on the screen.
 * 
 * @author Hank Gontarz
 */
public class P20Spiral extends TurtleDrawing {
    Random rand = new Random();

    public static void main(String[] args) {
        P20Spiral t = new P20Spiral();
        t.userDraw();
    }
    public void drawSpiral() {
        int cx = rand.nextInt(PANEL_WIDTH);
        int cy = rand.nextInt(PANEL_HEIGHT);
        double r = 1.0;
        
        clearScreen(Color.BLACK);
        setHeading(90);
        for (int i = 0; i < 5000; i += 10, r += 0.25) {
            int x = (int) (cx + r * Math.cos(Math.toRadians(i)));
            int y = (int) (cy + r * Math.sin(Math.toRadians(i)));
            setXY(x, y);
            filledCircle(5);
            setHeading(i + 90);
        }
    }    
    @Override
    public void userDraw() {
        say("P20Spiral by Hank Gontarz");
        setDelay(0);
        for (int i = 0; i < 10; i++) {
            drawSpiral();
        }
        ht(); //hide turtle
    }
}
