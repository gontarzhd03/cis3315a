package chap5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C5N45Std {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C5N45.txt"));
        double sum = 0;
        int count = 0;
        double deviation = 0.0;
        double mean = 0.0;
        double sumSquares = 0.0;
        while(sc.hasNextInt()) {
            count++;
            int mynum = sc.nextInt();
            sum += mynum;
            sumSquares += (mynum * mynum);
            
        }
        mean = sum / count;
        deviation = Math.sqrt((sumSquares - (sum * sum) / count) / (count - 1));
        System.out.printf("The mean is: %.2f\n", mean);
        System.out.printf("The standard deviation is: %.2f\n", deviation);
    }
}
