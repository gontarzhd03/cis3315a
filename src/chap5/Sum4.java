package chap5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Sum up unknown amount of numbers with sentinal value
 * @author Hank Gontarz
 */
public class Sum4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
        int sum = 0;
        int mynum = sc.nextInt();
        while(mynum >= 0) {
            sum += mynum;
            mynum = sc.nextInt();
        }
        System.out.println("The sum is: " + sum);
    }
}
