package chap5;

import java.util.Scanner;

/**
 * Sum up numbers
 * @author Hank Gontarz
 */
public class Sum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.print("How many numbers to sum: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.print("Enter number " + i + ": ");
            int mynum = sc.nextInt();
            sum += mynum;
        }
        System.out.println("The sum is: " + sum);
        double avg = (1.0 * sum / n);
        System.out.println("The average is: " + avg);
    }
}
