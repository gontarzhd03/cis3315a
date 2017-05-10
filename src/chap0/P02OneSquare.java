package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Direct the turtle to draw a square on the screen.
 *
 * @author Hank Gontarz
 */
public class P02OneSquare extends TurtleDrawing {

    public static void main(String[] args) {
        P02OneSquare t = new P02OneSquare();
        t.userDraw();
    }

    @Override
    public void userDraw() {
        say("P02OneSquare by Hank Gontarz");
        setDelay(0);
        fd(100);
        rt(90);
        fd(100);
        rt(90);
        fd(100);
        rt(90);
        fd(100);
        rt(90);
        ht(); //hide turtle
    }
}
