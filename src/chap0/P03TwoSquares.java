package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Draw two squares with different colors and sizes.
 *
 * @author Student Name
 */
public class P03TwoSquares extends TurtleDrawing {

    public static void main(String[] args) {
        P03TwoSquares t = new P03TwoSquares();
        t.userDraw();
    }

    @Override
    public void userDraw() {
        say("P03TwoSquares by Hank Gontarz");
        setDelay(0);
        fd(100);
        rt(90);
        fd(100);
        rt(90);
        fd(100);
        rt(90);
        fd(100);
        rt(90);
        setXY(150, getTurtleY());
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
