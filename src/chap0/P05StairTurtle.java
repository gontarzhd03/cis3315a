package chap0;

import phillips.turtle.TurtleDrawing;

/**
 * Draw a certain number of stairs going upward
 * 
 * @author Hank Gontarz
 */
public class P05StairTurtle extends TurtleDrawing {

    public static void main(String[] args) {
        P05StairTurtle t = new P05StairTurtle();
        t.userDraw();
    }
    
    public void oneStep(int stepLen) {
        fd(stepLen);
        lt(90);
        fd(stepLen);
        rt(90);
    }
    @Override
    public void userDraw() {
        int stepLen = 50;           //The length of each step
        int numSteps = 18;          //The number of steps to make
        int offsetStairsX = 300;    //The X offset to adjust
        int offsetStairsY = 300;    //The Y offset to adjust
        
        setDelay(0);
        int xHome = getTurtleX();
        int yHome = getTurtleY();
        setXY(xHome - offsetStairsX, yHome + offsetStairsY);
        say("P05StairTurtle by Hank Gontarz");
        for(int i = 0; i < numSteps; i++) {
            oneStep(stepLen);
        }
        fd(stepLen);
        ht(); //hide turtle
    }
}
