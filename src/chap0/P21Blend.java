package chap0;

import java.awt.Color;
import java.util.Random;
import static phillips.turtle.DrawingPanel.PANEL_HEIGHT;
import static phillips.turtle.DrawingPanel.PANEL_WIDTH;
import phillips.turtle.TurtleDrawing;

/**
 * Draw various shapes & colors on the screen.
 * 
 * @author Hank Gontarz
 */
public class P21Blend extends TurtleDrawing {
    Random rand = new Random();
    
    public static void main(String[] args) {
        P21Blend t = new P21Blend();
        t.userDraw();
    }
    public void drawStar(int width) {
        for(int i = 0; i < 50; i++) {
            fd(width);
            lt(95);
        }
    }
    public void drawSpiral() {
        int cx = rand.nextInt(PANEL_WIDTH);
        int cy = rand.nextInt(PANEL_HEIGHT);
        double r = 1.0;
        
        setDelay(-1);
        setHeading(90);
        for (int i = 0; i < 5000; i += 10, r += 0.25) {
            int x = (int) (cx + r * Math.cos(Math.toRadians(i)));
            int y = (int) (cy + r * Math.sin(Math.toRadians(i)));
            setXY(x, y);
            filledCircle(5);
            setHeading(i + 90);
        }
        draw();
    }
    public void drawFancyCircle() {
        int radius = rand.nextInt((PANEL_HEIGHT / 2));

        setDelay(-1);
        for (int i = radius; i > 0; i--) {
            setPenColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            circle(i);
        }
        draw();
    }
    public void drawFancySquare() {
        int width = rand.nextInt((PANEL_HEIGHT / 2));

        setDelay(-1);
        for (int i = width; i > 0; i-=2) {
            setPenColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            square(i);
            setXY(getTurtleX()+1, getTurtleY()+1);
        }
        draw();
    }
    public void drawFancyTriangle(int mode) {
        int width = rand.nextInt((PANEL_HEIGHT / 2));

        setDelay(-1);
        setHeading(0);
        setPenColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));        
        for (int i = width; i > 0; i -= 1) {
            fd(i);
            bk(i);
            switch(mode) {
                case 0:
                    setXY(getTurtleX() + 1, getTurtleY() + 1);
                    break;
                case 1:
                    setXY(getTurtleX(), getTurtleY() + 1);
                    break;
            }
        }
        draw();
    }
    public void drawShape(int shape) {
        setXY(rand.nextInt(PANEL_WIDTH), rand.nextInt(PANEL_HEIGHT));
        setPenColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        switch(shape) {
            case 0:
                filledOval(rand.nextInt((PANEL_WIDTH/2)), rand.nextInt((PANEL_HEIGHT/2)));
                break;
            case 1:
                filledCircle(rand.nextInt((PANEL_HEIGHT/2)));
                break;
            case 2:
                filledRectangle(rand.nextInt((PANEL_WIDTH/2)), rand.nextInt((PANEL_HEIGHT/2)));
                break;
            case 3:
                drawSpiral();
                break;
            case 4:
                drawStar(rand.nextInt((PANEL_WIDTH/2)));
                break;
            case 5:
                drawFancyCircle();
                break;
            case 6:
                drawFancySquare();
                break;
            case 7:
                drawFancyTriangle(rand.nextInt(3));
                break;
        }
    }
    @Override
    public void userDraw() {
        say("P21Blend by Hank Gontarz");
        for(int i = 0; i < 200; i++) {
            setDelay(0);
            drawShape(rand.nextInt(8)); //randomly draw various shapes
        }
        ht(); //hide turtle
    }
}
