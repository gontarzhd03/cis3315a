package chap5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Sum up unknown amount of numbers with sentinal value
 * @author Hank Gontarz
 */
public class Sum5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data2.txt"));
        int sum = 0;
        int count = 0;
        while(sc.hasNextInt()) {
            count++;
            int mynum = sc.nextInt();
            sum += mynum;
        }
        System.out.printf("The sum is: %d average %.4f", sum, (double)sum / count);
    }
}
