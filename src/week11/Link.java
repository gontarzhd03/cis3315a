package week11;

/**
 *
 * @author Hank Gontarz
 */
public class Link {
    public Friend data;
    public Link next;

    public Link(Friend data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "" + data.toString();
    }
}
