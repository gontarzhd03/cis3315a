package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Draw a triangle
 * 
 * @author Hank Gontarz
 */
public class P07Triangle extends TurtleDrawing {

    public static void main(String[] args) {
        P07Triangle t = new P07Triangle();
        t.userDraw();
    }

    @Override
    public void userDraw() {
        say("P07Triangle by Hank Gontarz");
        setDelay(0);
        fd(100);
        lt(120);
        fd(100);
        lt(120);
        fd(100);
        lt(120);
        ht(); //hide turtle
    }
}
