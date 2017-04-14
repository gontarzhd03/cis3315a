package sorts;

/**
 *
 * @author Hank Gontarz
 */
public class ComplexSorts {
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
    public static void quickSort(int[] list, String direction) {
        quickSort(list, 0, list.length-1, direction);
    }
    public static void quickSort(int[] list, int first, int last, String direction) {
        int pivotIndex = 0;
        
        if(last > first) {
            if(direction.equalsIgnoreCase("A")) {
                pivotIndex = partitionA(list, first, last, direction);
            }
            else if(direction.equalsIgnoreCase("D")) {
                pivotIndex = partitionD(list, first, last, direction);
            }
            quickSort(list, first, pivotIndex - 1, direction);
            quickSort(list, pivotIndex + 1, last, direction);
        }
    }
    public static int partitionA(int[] list, int first, int last, String direction) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        
//Loop stops when high & low cross each other
        while(high > low) {
//Search forward from left finding a value greater than or equal to pivot; find high values
            while(low <= high && list[low] <= pivot) low++;
//Search backward from right finding a value less than pivot; find low values
            while(low <= high && list[high] > pivot) high--;
//Swap high & low; lows are left, highs are on right
            if(high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
//Position high at the pivot point
        while(high > first && list[high] >= pivot) high--;
//Swap pivot with list[high]; pivot is centered
        if(pivot > list[high]) { 
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }
    public static int partitionD(int[] list, int first, int last, String direction) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        
//Loop stops when high & low cross each other
        while(high > low) {
            while(low <= high && list[low] > pivot) low++;    //find low values
            while(low <= high && list[high] <= pivot) high--; //find high values
//Swap high & low; lows are left, highs are on right
            if(high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
//Position high at the pivot point
        while(high > first && list[high] <= pivot) high--;
//        while(high > first && list[high] <= pivot) high--;
//Swap pivot with list[high]; pivot is centered
        if(pivot < list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }
}
