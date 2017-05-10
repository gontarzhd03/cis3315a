package chap0;

// DrawingPanel.java by John Phillips on 8/19/2014
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

/**
 * The basic drawing application with one panel containing a buffered drawing
 * area. Extend this class and draw on the Graphics2D offscreen object. Then
 * call the show(0) method to copy the offscreen buffer to the onscreen buffer
 * which will make your work visible.
 * 
 * I borrowed some ideas on double buffering and the show and draw methods from:
 * StdDraw.java at http://introcs.cs.princeton.edu/java/stdlib/
 *
 * @author John Phillips
 * @version 0.30
 */
public class DrawingPanel extends JPanel {

    /**
     *
     */
    protected static JFrame frame;

    /**
     * The width of the drawing panel in pixels.
     */
    public final static int PANEL_WIDTH = 800;

    /**
     * The height of the drawing panel in pixels.
     */
    public final static int PANEL_HEIGHT = 600;

    /**
     *
     */
    protected JPanel panel;

    /**
     *
     */
    protected final BufferedImage bufImage1;

    /**
     *
     */
    protected final BufferedImage bufImage2;

    /**
     *
     */
    protected final Graphics2D onscreen;

    /**
     *
     */
    protected final Graphics2D offscreen;

    /**
     *
     */
    protected boolean wait = false;

    private final JLabel myDrawingLbl;

    /**
     * Constructor to create a new double buffered drawing application.
     */
    public DrawingPanel() {
        super();
        this.panel = this;
        bufImage1 = new BufferedImage(PANEL_WIDTH, PANEL_HEIGHT,
                BufferedImage.TYPE_INT_ARGB);
        bufImage2 = new BufferedImage(PANEL_WIDTH, PANEL_HEIGHT,
                BufferedImage.TYPE_INT_ARGB);
        offscreen = bufImage1.createGraphics();
        onscreen = bufImage2.createGraphics();
        myDrawingLbl = new JLabel(new ImageIcon(bufImage2));

        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        this.add(myDrawingLbl, BorderLayout.CENTER);

        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        offscreen.addRenderingHints(hints);

        frame = new JFrame("Java Turtle Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    /**
     * Set the background color for the drawing. This will erase anything
     * already painted on the panel.
     *
     * @param bgcolor
     */
    public void setMyPanelColor(Color bgcolor) {
        offscreen.setColor(bgcolor);
        offscreen.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
    }

    public Color getMyPanelColor() {
        return offscreen.getBackground();
    }

    public void setMyColor(Color color) {
        offscreen.setColor(color);
    }

    public Color getMyColor() {
        return offscreen.getColor();
    }

    /**
     * Prepare to show the current offscreen image after the given time delay in
     * milliseconds.
     *
     * @param timeDelay in milliseconds
     */
    public void show(int timeDelay) {
        wait = false;
        if (timeDelay >= 0) {
            draw();
        }
        if (timeDelay > 0) {
            try {
                Thread.sleep(timeDelay);
            } catch (InterruptedException e) {
                System.out.println("Error in show");
            }
            wait = true;
        }
    }

    /**
     * Copy the offscreen image to the on-screen one, repaint the screen, and
     * then draw the turtle in its current position.
     *
     */
    public void draw() {
        if (wait) {
            return;
        }
        onscreen.drawImage(bufImage1, 0, 0, null);
        frame.repaint();
    }

    /**
     * Print the given string on the console.
     *
     * @param s string to print
     */
    public void print(String s) {
        System.out.println(s);
    }

    /**
     * Draw the given string on the screen at the current turtle position.
     *
     * @param s string to draw
     */
    public void say(String s) {
        //say("C1N2 by Student Name", 20, PANEL_HEIGHT - 20, 14, Color.red);
        say(s, 20, PANEL_HEIGHT - 20, 14, Color.red);
    }

    /**
     * Draw the given string on the screen at the given x,y coordinates.
     *
     * @param s string to draw
     * @param x x coordinate
     * @param y y coordinate
     */
    public void say(String s, int x, int y) {
        offscreen.drawString(s, x, y);
        show(0);
    }

    /**
     * Draw the given string on the screen at the given x,y coordinates and in
     * the given stroke.
     *
     * @param s message to draw
     * @param x x coordinate
     * @param y y coordinate
     * @param fontSize in points
     */
    public void say(String s, int x, int y, int fontSize) {
        Font font = new Font("Courier", Font.PLAIN, fontSize);
        offscreen.setFont(font);
        say(s, x, y);
    }

    /**
     * Draw the given string on the screen at the given x,y coordinates and in
     * the given color.
     *
     * @param s message to draw
     * @param x x coordinate
     * @param y y coordinate
     * @param c color
     */
    public void say(String s, int x, int y, Color c) {
        Color oldColor = offscreen.getColor();
        offscreen.setColor(c);
        say(s, x, y);
        offscreen.setColor(oldColor);
    }

    /**
     * Draw the given string on the screen at the given x,y coordinates and in
     * the given color.
     *
     * @param s message to draw
     * @param x x coordinate
     * @param y y coordinate
     * @param fontSize in points
     * @param c color
     */
    public void say(String s, int x, int y, int fontSize, Color c) {
        Font font = new Font("Courier", Font.PLAIN, fontSize);
        offscreen.setFont(font);
        Color oldColor = offscreen.getColor();
        offscreen.setColor(c);
        say(s, x, y);
        offscreen.setColor(oldColor);
    }

    /**
     * Display a dialog box on the screen with the given message.
     *
     * @param s message to display
     */
    public void outputDialog(String s) {
        JOptionPane.showMessageDialog(frame, s, "Output Dialog",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Display an input dialog box on the screen.
     *
     * @param s message to display
     * @return String containing the value entered or null if no value
     */
    public String inputDialog(String s) {
        return JOptionPane.showInputDialog(frame, s,
                "Input Dialog", 3);
    }
}
