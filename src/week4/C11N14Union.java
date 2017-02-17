package week4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C11N14Union {
    public static ArrayList<Integer> union(ArrayList<Integer> lst1, ArrayList<Integer> lst2) {
        ArrayList<Integer> rc = new ArrayList(lst1.size() + lst2.size());
        rc.addAll(lst1);
        rc.addAll(lst2);
        return rc;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList(5);
        ArrayList<Integer> list2 = new ArrayList(5);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter five integers for list1: ");
        String line = sc.nextLine();
        String[] numbers = line.split(" ");
        if(numbers.length >= 5) {
            for(int j = 0; j < numbers.length; j++) {
                list1.add(Integer.parseInt(numbers[j]));
            }
        }
        System.out.print("Enter five integers for list2: ");
        line = sc.nextLine();
        numbers = line.split(" ");
        if(numbers.length >= 5) {
            for(int j = 0; j < numbers.length; j++) {
                list2.add(Integer.parseInt(numbers[j]));
            }
        }
        ArrayList<Integer> glued = union(list1, list2);
        System.out.print("The combined list is: ");
        for(int i = 0; i < glued.size(); i++) {
            System.out.print(glued.get(i) + " ");
        }
        System.out.println("");
    }
}
