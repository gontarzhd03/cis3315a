package chap2;

import java.util.Scanner;

/**
 * Compute the gratuity and total from a check.
 * @author Hank Gontarz
 */
public class P02N05ComputeTips {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Compute gratuity and total bill! *****");
        System.out.print("Enter a subtotal and gratuity rate(%): ");
        double subtotal = sc.nextDouble();
        double gratuity = sc.nextDouble();
        
        gratuity = (gratuity / 100.0) * subtotal;
        double total = subtotal + gratuity;
        
        System.out.printf("The gratuity is $%.2f and total is $%.2f\n", gratuity, total);
    }
}
