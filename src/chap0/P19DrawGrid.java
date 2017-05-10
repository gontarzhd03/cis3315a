package chap0;

import java.awt.Color;
import static phillips.turtle.DrawingPanel.PANEL_HEIGHT;
import static phillips.turtle.DrawingPanel.PANEL_WIDTH;
import phillips.turtle.TurtleDrawing;

/**
 * Draw a grid on the screen.
 * 
 * @author Hank Gontarz
 */
public class P19DrawGrid extends TurtleDrawing {

    public static void main(String[] args) {
        P19DrawGrid t = new P19DrawGrid();
        t.userDraw();
    }
    public void drawGrid(int gridGap) {
        int numHoriz = PANEL_HEIGHT / gridGap;
        int numVert = PANEL_WIDTH / gridGap;

        setPenColor(Color.BLUE);
        setPenSize(1);
        print("Vert: " + numVert + " Horiz: " + numHoriz);
        for(int i = 0; i < numHoriz; i++) {  //horizontal lines
            setXY(0, (i * gridGap));
            fd(PANEL_WIDTH);
        }
        for(int i = 0; i < numVert; i++) {  //vertical lines
            setXY((i * gridGap), 0);
            setHeading(90);
            fd(PANEL_HEIGHT);
        }
    }
    @Override
    public void userDraw() {
        say("P19DrawGrid by Hank Gontarz");
        setDelay(0);
        drawGrid(20);
        ht(); //hide turtle
    }
}
