package chap0;

import java.awt.Color;
import java.util.Random;
import phillips.turtle.TurtleDrawing;

/**
 * Draw a wave on the screen.
 * 
 * @author Hank Gontarz
 */
public class P17Wave extends TurtleDrawing {
    Random rand = new Random();
    
    public static void main(String[] args) {
        P17Wave t = new P17Wave();
        t.userDraw();
    }
    public void drawStar(int width) {
        for(int i = 0; i < 19; i++) {
            fd(width);
            lt(95);
        }
    }
    public void drawWave() {
        for(int x = 0; x < PANEL_WIDTH; x += 20) {
            int y = (int) (Math.sin(Math.toRadians(x)) * 200);
            print("x = " + x + ", y = " + y);
            setXY(x, y + 300);
            setHeading(0);
            setPenColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            drawStar(100);
        }
    }
    @Override
    public void userDraw() {
        say("P17Wave by Hank Gontarz");
        setDelay(0);
        drawWave();
        ht(); //hide turtle
    }
}
