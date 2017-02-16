package week4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hgontarz
 */
public class C11N4Array {
    public static Integer max(ArrayList<Integer> list) {
        Integer rc = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > rc) {
                rc = list.get(i);
            }
        }
        return rc;
    }
}

class C11N4Test {
    public static void main(String[] args) {
        int num;
        ArrayList<Integer> mylist = new ArrayList();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a series of spaced numbers followed by zero!");
        while(sc.hasNextInt()) {
            num = sc.nextInt();
            if(num != 0) {
                mylist.add(num);
            }
            else break;
        }
        System.out.println("Max is: " + C11N4Array.max(mylist));
    }
}