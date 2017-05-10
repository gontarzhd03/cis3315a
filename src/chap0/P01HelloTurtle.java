package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Draw something on the screen.
 * 
 * @author Hank Gontarz
 */
public class P01HelloTurtle extends TurtleDrawing {

    public static void main(String[] args) {
        P01HelloTurtle t = new P01HelloTurtle();
        t.userDraw();
    }

    @Override
    public void userDraw() {
        say("P01HelloTurtle by Hank Gontarz");
        setDelay(0);
        
        ht(); //hide turtle
    }
}
