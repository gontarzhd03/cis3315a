package chap5;

import java.util.Scanner;

/**
 * Sum up unknown amount of numbers with sentinal value
 * @author Hank Gontarz
 */
public class Sum3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String answer = "y";
        System.out.print("Enter a number (-1 to quit): ");
        int mynum = sc.nextInt();
        while(mynum >= 0) {
            sum += mynum;
            System.out.print("Enter a number (-1 to quit): ");
            mynum = sc.nextInt();
        }
        System.out.println("The sum is: " + sum);
    }
}
