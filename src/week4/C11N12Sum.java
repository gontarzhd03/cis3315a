package week4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C11N12Sum {
    public static double sum(ArrayList<Double> list) {
        double rc = 0.0;
        
        for(int i = 0; i < list.size(); i++) {
            rc += list.get(i);
        }
        return rc;
    }    
    public static void main(String[] args) {
        ArrayList<Double> arr = new ArrayList(5);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 5 decimal numbers: ");
        for(int i = 0; i < 5; i++) {
            if(sc.hasNextDouble()) {
                arr.add(sc.nextDouble());
            }
        }
        System.out.println("The first five summed numbers are: " + sum(arr));
    }
}
