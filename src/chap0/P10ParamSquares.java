package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Draw Squares using a method with a parameter; (Make a house with methods)
 * 
 * @author Hank Gontarz
 */
public class P10ParamSquares extends TurtleDrawing {

    public static void main(String[] args) {
        P10ParamSquares t = new P10ParamSquares();
        t.userDraw();
    }
    public void myTriangle(int width) {
        fd(width);
        lt(120);
        fd(width);
        lt(120);
        fd(width);
        lt(120);
    }
    public void myRectangle(int width, int height) {
        fd(width);
        rt(90);
        fd(height);
        rt(90);
        fd(width);
        rt(90);
        fd(height);
        rt(90);
    }
    @Override
    public void userDraw() {
        say("P10ParamSquares by Hank Gontarz");
        setDelay(0);
        setXY(200, 300); //this.getTurtleY());
        myRectangle(200, 200);
        setXY(0, 0);
        myRectangle(200, 200);
        setXY(700, 500);
        myRectangle(100, 100);
        ht(); //hide turtle
    }
}
