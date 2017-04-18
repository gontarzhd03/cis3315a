package week11;

/**
 *
 * @author Hank Gontarz
 */
public class Link {
    public double data;
    public Link next;

    public Link(double data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
