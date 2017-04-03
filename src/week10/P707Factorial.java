package week10;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class P707Factorial {
    public static long factorial(int n) {
        if(n == 0) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a nonnegative integer: ");
        int n = sc.nextInt();
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }
}
