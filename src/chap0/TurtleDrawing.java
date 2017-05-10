package chap0;

// TurtleDrawing.java by John Phillips on 8/18/2014
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

/**
 * The basic turtle drawing environment complete with a turtle object.
 *
 * @author John Phillips
 * @version 0.50
 */
abstract public class TurtleDrawing extends DrawingPanel {

    private final static Color BACKGROUND_COLOR = Color.WHITE;

    private final JavaTurtle t;
    private int delay;
    private int traceLineCount;
    private boolean traceOn;

    /**
     * Constructor to create a new double buffered drawing application.
     */
    public TurtleDrawing() {
        super();
        t = new JavaTurtle(PANEL_WIDTH / 2, PANEL_HEIGHT / 2, 0);
        delay = 200;
        traceLineCount = 1;
        traceOn = false;
        System.out.println("Java Turtle Drawing Software by John Phillips on 20140818");
        System.out.print("Drawing Panel Width = " + PANEL_WIDTH
                + " pixels and Height = " + PANEL_HEIGHT + " pixels\n\n");
        clearScreen(BACKGROUND_COLOR);
        offscreen.setFont(new Font("Courier", Font.PLAIN, 12));
        offscreen.setColor(Color.red);
        //userDraw();
    }

    /**
     * This abstract method is implemented by the user and will contain their
     * drawing commands.
     *
     */
    abstract public void userDraw();

    /**
     * Set the time delay between drawing commands in milliseconds. Use 500 for
     * a half second delay. Use 0 for no delay.
     *
     * Use -1 for no delay and no redraw between commands. Finish with the
     * draw() command to do the actual drawing.
     *
     * @param delay
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * Display information on the drawing commands being executed.
     *
     */
    public void setTraceOn() {
        this.traceOn = true;
    }

    /**
     * Turn off the display of information on the drawing commands being
     * executed.
     *
     */
    public void setTraceOff() {
        this.traceOn = false;
    }

    /**
     * Pass in the turtle command that is currently being executed and then
     * display relevant information in the output window.
     *
     * @param command
     */
    private void trace(String command) {
        if (this.traceOn) {
            System.out.printf("%5d: %-14s %20s\n", traceLineCount++, command, about());
        }
    }

    /**
     * Copy the offscreen image to the on-screen one, repaint the screen, and
     * then draw the turtle in its current position.
     *
     */
    @Override
    public void draw() {
        if (wait) {
            return;
        }
        onscreen.drawImage(bufImage1, 0, 0, null);
        if (t.isTurtleVisible()) {
            drawTurtle();
        }
        frame.repaint();
    }

    /**
     * Returns a message about the current location and settings of the turtle.
     *
     * @return a message about the turtle
     */
    public String about() {
        return ("x=" + t.getX() + " y=" + t.getY()
                + " angle=" + t.getHeading() % 360 + " color=" + t.getPenColor()
                + " stroke=" + t.getPenSize() + " isPenDown=" + t.isPenDown());
    }

    /**
     * Move turtle from the current location to the point x,y without drawing.
     *
     * @param x
     * @param y
     */
    public void setXY(int x, int y) {
        t.setX(x);
        t.setY(y);
//        boolean myPenIsDown = t.isPenDown();
//        if (myPenIsDown) {
//            t.setPenDown(false);
//        }
//        drawXY(x2, y2);
//        t.setPenDown(myPenIsDown);
        show(delay);
        trace("setXY(" + x + "," + y + ")");
    }

    /**
     *
     */
    public void clearScreen() {
        clearScreen(BACKGROUND_COLOR);
    }

    /**
     *
     * @param c
     */
    public void clearScreen(Color c) {
        t.setX(PANEL_WIDTH / 2);
        t.setY(PANEL_HEIGHT / 2);
        t.setHeading(0);
        setMyPanelColor(c);
    }

    /**
     *
     * @param c
     */
    public void setPenColor(Color c) {
        t.setPenColor(c);
    }

    /**
     *
     * @param points
     */
    public void setPenSize(int points) {
        t.setPenSize(points);
    }

    /**
     * Set the turtle's heading angle in degrees. Zero degrees is to the right
     * on the x-axis. 90 degrees is clockwise and pointing straight down on the
     * screen.
     *
     * @param angle
     */
    public void setHeading(int angle) {
        t.setHeading(angle);
    }

    /**
     * Get the turtle's x coordinate.
     *
     * @return x
     */
    public int getTurtleX() {
        return (t.getX());
    }

    /**
     * Get the turtle's y coordinate.
     *
     * @return y
     */
    public int getTurtleY() {
        return (t.getY());
    }

    /**
     * Get the turtle's heading angle in degrees. Zero degrees is to the right
     * on the x-axis. 90 degrees is clockwise and pointing straight down on the
     * screen.
     *
     * @return angle
     */
    public int getHeading() {
        return (t.getHeading());
    }

    /**
     * Lift the pen up so that no drawing will take place.
     */
    public void penUp() {
        t.setPenDown(false);
    }

    /**
     * Lift the pen up so that no drawing will take place.
     */
    public void pu() {
        penUp();
    }

    /**
     * Set the pen down to draw.
     */
    public void penDown() {
        t.setPenDown(true);
    }

    /**
     * Set the pen down to draw.
     */
    public void pd() {
        penDown();
    }

    /**
     * Draw a line of the given length along the current heading.
     *
     * @param distance
     */
    private void drawLine(int distance) {
        int oldX = t.getX();
        int oldY = t.getY();
        double radians = Math.toRadians(t.getHeading());
        t.setX(oldX + (int) Math.round(distance * Math.cos(radians)));
        t.setY(oldY + (int) Math.round(distance * Math.sin(radians)));

        if (t.isPenDown()) {
            offscreen.setColor(t.getPenColor());
            offscreen.setStroke(new BasicStroke(t.getPenSize()));
            offscreen.drawLine(oldX, oldY, t.getX(), t.getY());
        }
        show(delay);
    }

    /**
     * Draw from the current location to the center of the screen.
     *
     */
    public void home() {
        drawXY(PANEL_WIDTH / 2, PANEL_HEIGHT / 2);
    }

    /**
     * Draw from current location to the point x2,y2.
     *
     * @param x2
     * @param y2
     */
    public void drawXY(int x2, int y2) {
        int oldX = t.getX();
        int oldY = t.getY();
        t.setX(x2);
        t.setY(y2);
        if (t.isPenDown()) {
            offscreen.setColor(t.getPenColor());
            offscreen.setStroke(new BasicStroke(t.getPenSize()));
            offscreen.drawLine(oldX, oldY, x2, y2);
        }
        show(delay);
        trace("drawXY(" + x2 + "," + y2 + ")");
    }

    /**
     * If the pen is down then a line is drawn as the turtle moves forward the
     * given distance. If the pen is up then the turtle still moves but without
     * drawing a line.
     *
     * @param distance in units of pixels
     */
    public void forward(int distance) {
        drawLine(distance);
        trace("forward(" + distance + ")");
    }

    /**
     *
     * @param distance
     */
    public void fd(int distance) {
        drawLine(distance);
        trace("fd(" + distance + ")");
    }

    /**
     *
     * @param distance
     */
    public void backward(int distance) {
        drawLine(-distance);
        trace("backward(" + distance + ")");
    }

    /**
     *
     * @param distance
     */
    public void back(int distance) {
        drawLine(-distance);
        trace("back(" + distance + ")");
    }

    /**
     *
     * @param distance
     */
    public void bk(int distance) {
        drawLine(-distance);
        trace("bk(" + distance + ")");
    }

    /**
     * Turn the turtle to the right (clockwise) a given number of degrees.
     *
     * @param angle
     */
    public void right(int angle) {
        t.setHeading(t.getHeading() + angle);
        show(delay);
        trace("right(" + angle + ")");
    }

    /**
     *
     * @param angle
     */
    public void rt(int angle) {
        right(angle);
    }

    /**
     * Turn the turtle to the left (counter-clockwise) a given number of
     * degrees.
     *
     * @param angle
     */
    public void left(int angle) {
        t.setHeading(t.getHeading() - angle);
        show(delay);
        trace("left(" + angle + ")");
    }

    /**
     *
     * @param angle
     */
    public void lt(int angle) {
        left(angle);
    }

    /**
     * Draw a circle of radius r with the center point at the turtle's current
     * x,y location.
     *
     * @param r
     */
    public void circle(int r) {
        oval(r, r);
    }

    /**
     * Draw a filled circle of radius r with the center point at the turtle's
     * current x,y location.
     *
     * @param r
     */
    public void filledCircle(int r) {
        filledOval(r, r);
    }

    /**
     * Draw an oval of a given width and height with the center point at the
     * turtle's current x,y location.
     *
     * @param width
     * @param height
     */
    public void oval(int width, int height) {
        if (t.isPenDown()) {
            offscreen.setColor(t.getPenColor());
            offscreen.setStroke(new BasicStroke(t.getPenSize()));
            offscreen.drawOval(t.getX() - width / 2, t.getY() - height / 2, width, height);
        }
        show(delay);
        trace("oval(" + width + "," + height + ")");
    }

    /**
     * Draw a filled oval of a given width and height with the center point at
     * the turtle's current x,y location.
     *
     * @param width
     * @param height
     */
    public void filledOval(int width, int height) {
        if (t.isPenDown()) {
            offscreen.setColor(t.getPenColor());
            offscreen.setStroke(new BasicStroke(t.getPenSize()));
            offscreen.fillOval(t.getX() - width / 2, t.getY() - height / 2,
                    width, height);
        }
        show(delay);
        trace("filledOval(" + width + "," + height + ")");
    }

    /**
     * Draw a square of a given width with the top left corner of the square at
     * the turtle's current x,y location.
     *
     * @param width
     */
    public void square(int width) {
        rectangle(width, width);
    }

    /**
     * Draw a filled square of a given width with the top left corner of the
     * square at the turtle's current x,y location.
     *
     * @param width
     */
    public void filledSquare(int width) {
        filledRectangle(width, width);
    }

    /**
     * Draw a rectangle of a given width and height with the top left corner of
     * the rectangle at the turtle's current x,y location.
     *
     * @param width
     * @param height
     */
    public void rectangle(int width, int height) {
        if (t.isPenDown()) {
            offscreen.setColor(t.getPenColor());
            offscreen.setStroke(new BasicStroke(t.getPenSize()));
            offscreen.drawRect(t.getX(), t.getY(), width, height);
        }
        show(delay);
        trace("rectangle(" + width + "," + height + ")");
    }

    /**
     * Draw a filled rectangle of a given width and height with the top left
     * corner of the rectangle at the turtle's current x,y location.
     *
     * @param width
     * @param height
     */
    public void filledRectangle(int width, int height) {
        if (t.isPenDown()) {
            offscreen.setColor(t.getPenColor());
            offscreen.setStroke(new BasicStroke(t.getPenSize()));
            offscreen.fillRect(t.getX(), t.getY(), width, height);
        }
        show(delay);
        trace("filledRectangle(" + width + "," + height + ")");
    }

    public void arc(int width, int height, int startAngle, int arcAngle) {
        if (t.isPenDown()) {
            offscreen.setColor(t.getPenColor());
            offscreen.setStroke(new BasicStroke(t.getPenSize()));
            offscreen.drawArc(t.getX(), t.getY(), width, height, startAngle, arcAngle);
        }
        show(delay);
        trace("Arc(" + width + "," + height + "," + startAngle + "," + arcAngle + ")");
    }

    public void showTurtle() {
        t.setTurtleVisible(true);
        show(0);
    }

    public void st() {
        showTurtle();
    }

    public void hideTurtle() {
        t.setTurtleVisible(false);
        show(0);
    }

    public void ht() {
        hideTurtle();
    }

    /**
     * Draw a small turtle on the on-screen buffer at the current turtle
     * location. This makes the turtle appear to move between commands as the
     * offscreen buffer copy erases the old turtle image after each command.
     *
     */
    void drawTurtle() {
        int r = 15;
        int x1 = t.getX();
        int y1 = t.getY();
        int xc = x1 - r;
        int yc = y1 - r;
        int x2 = x1 + (int) Math.round(r
                * Math.cos(Math.toRadians(t.getHeading())));
        int y2 = y1 + (int) Math.round(r
                * Math.sin(Math.toRadians(t.getHeading())));
        Color c = onscreen.getColor();
        // draw a green turtle body
        onscreen.setColor(Color.green);
        onscreen.fillOval(xc, yc, r * 2, r * 2);
        // draw an orange outline around the turtle body
        onscreen.setColor(Color.orange);
        onscreen.setStroke(new BasicStroke(3));
        onscreen.drawOval(xc, yc, r * 2, r * 2);
        // draw turtle head in direction of current heading
        onscreen.setColor(Color.ORANGE);
        onscreen.fillOval(x2 - r / 2, y2 - r / 2, r, r);
        // draw a filled circle on back of turtle showing current drawing color
        onscreen.setColor(t.getPenColor());
        onscreen.fillOval(x1 - 5, y1 - 5, 10, 10);
        // draw a small black circle around the filled pen circle
        onscreen.setColor(Color.black);
        onscreen.drawOval(x1 - 5, y1 - 5, 10, 10);
        onscreen.setColor(c);
    }
}
