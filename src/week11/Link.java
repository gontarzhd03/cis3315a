package week11;

/**
 *
 * @author Hank Gontarz
 */
public class Link {
    public int index;
    public double data;
    public Link next;

    public Link(int index, double data) {
        this.index = index;
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return index + ", " + data;
    }
}
