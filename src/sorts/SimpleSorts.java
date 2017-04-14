package sorts;

/**
 *
 * @author Hank Gontarz
 */
public class SimpleSorts {
    public static void bubbleSort(int[] a, String direction) {
        int out, in;
        boolean moreChanges = true;

        for (out = a.length - 1; out > 0 && moreChanges; out--) {
            moreChanges = false;
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1] && direction.equalsIgnoreCase("A") ||
                    a[in] < a[in + 1] && direction.equalsIgnoreCase("D")) {
                    int temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                    moreChanges = true;
                }
            }
        }
    }
    public static void selectionSort(int[] list, String direction) {
        for(int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;
            
            for(int j = i + 1; j < list.length; j++) {
                if(direction.equalsIgnoreCase("A") && currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
                else if(direction.equalsIgnoreCase("D") && currentMin < list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if(currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
    public static void insertionSort(int[] list, String direction) {
        for(int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            if(direction.equalsIgnoreCase("A")) {
                for(k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                    list[k + 1] = list[k];
                }
                list[k + 1] = currentElement;
            }
            else if(direction.equalsIgnoreCase("D")) {
                for(k = i - 1; k >= 0 && list[k] < currentElement; k--) {
                    list[k + 1] = list[k];
                }
                list[k + 1] = currentElement;
            }
        }
    }
}