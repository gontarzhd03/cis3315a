package chap5;

import java.util.Scanner;

/**
 * Sum up unknown amount of numbers
 * @author Hank Gontarz
 */
public class Sum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String answer = "y";
        while(answer.equalsIgnoreCase("y")) {
            System.out.print("Enter a number: ");
            int mynum = sc.nextInt();
            sum += mynum;
            System.out.print("Another number y/n: ");
            answer = sc.next();
        }
        System.out.println("The sum is: " + sum);
    }
}
