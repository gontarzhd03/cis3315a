package chap0;

// JavaTurtle.java by John Phillips on August 18, 2014
// This class represents a single turtle object.
import java.awt.Color;

/**
 * Provides basic functionality for turtle graphics.
 *
 * @author John Phillips
 * @version 0.50 on 20140818
 */
public class JavaTurtle {

    private int x;
    private int y;
    private int heading;
    private int penSize;
    private Color penColor;
    private boolean penDown;
    private boolean turtleVisible;

    /**
     * Constructor to create a new turtle object. We pass in the current
     * graphics object and the drawing panel.
     *
     * @param x
     * @param y
     * @param angle
     */
    public JavaTurtle(int x, int y, int angle) {
        this.x = x;
        this.y = y;
        this.heading = angle;
        this.penSize = 3;
        this.penColor = Color.red;
        this.penDown = true;
        this.turtleVisible = true;
    }

    /**
     * Get the x coordinate of the turtle.
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate of the turtle.
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Get the turtle's heading angle in degrees.
     *
     * @return
     */
    public int getHeading() {
        return heading;
    }

    /**
     * Get the current turtle drawing penColor.
     *
     * @return
     */
    public Color getPenColor() {
        return penColor;
    }

    /**
     * Get the turtle's penSize (line width in pixels).
     *
     * @return
     */
    public int getPenSize() {
        return penSize;
    }

    /**
     * Return true if the turtle pen is down.
     *
     * @return
     */
    public boolean isPenDown() {
        return penDown;
    }

    /**
     * Return true is we are showing the location of a small turtle on the
     * screen at the end of each command.
     *
     * @return
     */
    public boolean isTurtleVisible() {
        return turtleVisible;
    }

    /**
     * Set the x coordinate of the turtle's position.
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set the y coordinate of the turtle's position.
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Set the turtle's heading angle in degrees. Zero degrees is to the right
     * on the x-axis. 90 degrees is clockwise and pointing straight down on the
     * screen.
     *
     * @param angle
     */
    public void setHeading(int angle) {
        this.heading = angle;
    }

    /**
     * Set the penColor the turtle will draw. The penColor object can be in the
     * form of:
     *
     * Color.red or Color.blue and so on
     *
     * or
     *
     * new Color(255, 175, 220) where the values go from 0 to 255 and represent
     * red, green, and blue.
     *
     * @param c
     */
    public void setPenColor(Color c) {
        this.penColor = c;
    }

    /**
     * Set the penSize (line width in pixels) the turtle will draw.
     *
     * @param s
     */
    public void setPenSize(int s) {
        this.penSize = s;
    }

    /**
     * Set the penSize (line width in pixels) the turtle will draw.
     *
     * @param b
     */
    public void setPenDown(boolean b) {
        this.penDown = b;
    }

    /**
     * If true a small turtle will be drawn on the screen after each command.
     *
     * @param isVisible
     */
    public void setTurtleVisible(boolean isVisible) {
        turtleVisible = isVisible;
    }
}
