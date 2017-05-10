package chap7;

/**
 *
 * @author Hank Gontarz
 */
public class C7Stats {
    private int[] x = new int[100];
    private int n = 0;

    public C7Stats() {
        System.out.println("In constructor");
        x[0] = 5;
        x[1] = 10;
        x[2] = 15;
        n = 3;
    }

    public int sum() {
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += x[i];
        }
        return total;
    }
}
