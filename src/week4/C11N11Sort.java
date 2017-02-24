package week4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C11N11Sort {
    public static void sort1(ArrayList<Integer> list) {
        list.sort((Integer n1, Integer n2) -> n1 - n2);
    }
    public static void sort2(ArrayList<Integer> list) {
       list.sort(Comparator.naturalOrder());
    }
    public static void sort3(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            int currentMin = list.get(i);
            int currentMinIndex = i;
            
            for(int j = i + 1; j < list.size(); j++) {
                if(currentMin > list.get(j)) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }
            if(currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList(5);
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter 5 integer numbers: ");
        for(int i = 0; i < 5; i++) {
            if(sc.hasNextInt()) {
                arr.add(sc.nextInt());
            }
        }
        sort1(arr);
        System.out.print("Sorted numbers: ");
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }
}
