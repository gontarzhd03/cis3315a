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
    public static void mergeSort(int[] a, String direction) {
        int nElems = a.length;
        int[] workSpace = new int[nElems];
        recMergeSort(a, direction, workSpace, 0, nElems-1);
    }
    public static void recMergeSort(int[] a, String direction, int[] workSpace, int lowerBound, int upperBound) {
        if(lowerBound == upperBound) {
            return;
        }
        else {
            int mid = (lowerBound + upperBound)/2;
            recMergeSort(a, direction, workSpace, lowerBound, mid);
            recMergeSort(a, direction, workSpace, mid+1, upperBound);
            merge(a, direction, workSpace, lowerBound, mid+1, upperBound);
        }
    }
    public static void merge(int[] a, String direction, int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        
        while(lowPtr <= mid && highPtr <= upperBound) {
            if(a[lowPtr] < a[highPtr] && direction.equalsIgnoreCase("A") ||
               a[lowPtr] > a[highPtr] && direction.equalsIgnoreCase("D")) {
                workSpace[j++] = a[lowPtr++];
            }
            else {
                workSpace[j++] = a[highPtr++];
            }
        }
        while(lowPtr <= mid) {
            workSpace[j++] = a[lowPtr++];
        }
        while(highPtr <= upperBound) {
            workSpace[j++] = a[highPtr++];
        }
        for(j = 0; j < n; j++) {
            a[lowerBound + j] = workSpace[j];
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
}