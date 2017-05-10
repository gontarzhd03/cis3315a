package chap2;

import java.util.Scanner;

/**
 * Convert feet into meters
 * @author Hank Gontarz
 */
public class P02N03FeetMeters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Convert feet into meters! *****");
        System.out.print("Enter a value for feet: ");
        double feet = sc.nextDouble();
        double meters = feet * 0.305;
        
        System.out.printf("%.2f feet is %.4f meters\n", feet, meters);
    }
}
