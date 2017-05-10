package chap0;

import java.awt.Color;
import phillips.turtle.TurtleDrawing;

/**
 * Draw the classic Olympic Rings
 * 
 * @author Hank Gontarz
 */
public class P15OlympicRings extends TurtleDrawing {

    public static void main(String[] args) {
        P15OlympicRings t = new P15OlympicRings();
        t.userDraw();
    }

    @Override
    public void userDraw() {
        int ringSize = 100;
        int ringOffsetX = 16;
        int ringPosX = 0;
        int ringPosY = 0;
        
        say("P15OlympicRings by Hank Gontarz");
        setDelay(0);
        int xHome = getTurtleX();
        xHome -= ringSize;
        int yHome = getTurtleY();
        setPenSize(8);
        for(int i = 0; i < 5; i++) {
            switch(i) {
                case 0:
                    ringPosX = xHome + (ringSize * i) + (ringOffsetX * i);
                    ringPosY = yHome;
                    setPenColor(Color.BLUE);
                    break;
                case 1:
                    ringPosX = xHome + (ringSize * i) + (ringOffsetX * i);
                    ringPosY = yHome;
                    setPenColor(Color.BLACK);
                    break;
                case 2:
                    ringPosX = xHome + (ringSize * i) + (ringOffsetX * i);
                    ringPosY = yHome;
                    setPenColor(Color.RED);
                    break;
                case 3:
                    ringPosX = xHome + (ringSize * (i - 3)) + (ringSize / 2) + (ringOffsetX * (i - 3));
                    ringPosY = yHome + (ringSize / 2);
                    setPenColor(Color.YELLOW);
                    break;
                case 4:
                    ringPosX = xHome + (ringSize * (i - 3)) + (ringSize / 2) + (ringOffsetX * (i - 3));
                    ringPosY = yHome + (ringSize / 2);
                    setPenColor(Color.GREEN);
                    break;
            }
            setXY(ringPosX, ringPosY);
            circle(ringSize);
        }
        ht();
    }
}
