package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Draw a house
 * 
 * @author Hank Gontarz
 */
public class P08House extends TurtleDrawing {

    public static void main(String[] args) {
        P08House t = new P08House();
        t.userDraw();
    }

    @Override
    public void userDraw() {
        say("P08House by Hank Gontarz");
        setDelay(0);
//triangle
        fd(100);
        lt(120);
        fd(100);
        lt(120);
        fd(100);
        lt(120);
//square
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
