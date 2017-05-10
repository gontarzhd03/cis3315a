package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Draw Squares using a Method
 * 
 * @author Hank Gontarz
 */
public class P09MethodSquares extends TurtleDrawing {

    public static void main(String[] args) {
        P09MethodSquares t = new P09MethodSquares();
        t.userDraw();
    }

    
    public void mySquare() {
//square
        fd(100);
        rt(90);
        fd(100);
        rt(90);
        fd(100);
        rt(90);
        fd(100);
        rt(90);
    }
    @Override
    public void userDraw() {
        say("P09MethodSquares by Hank Gontarz");
        setDelay(0);
        mySquare();
        setXY(200, 300);
        mySquare();
        ht(); //hide turtle
    }
}
