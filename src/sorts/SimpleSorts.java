package sorts;

/**
 *
 * @author Hank Gontarz
 */
public class SimpleSorts {
    public static void bubbleSort(int[] a, String direction) {
        int out, in;
        
        for(out = a.length-1; out > 0; out--) {
            for(in = 0; in < out; in++) {
                if(a[in] > a[in+1] && direction.equalsIgnoreCase("A") || a[in] < a[in + 1] && direction.equalsIgnoreCase("D")) {
                    int temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
            }
        }
    }
}
