package chap2;

import java.util.Scanner;

/**
 * Compute the future investment value. (Financial)
 * @author Hank Gontarz
 */
public class P02N21FutureInvest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Compute future investment value! *****");
        System.out.print("Enter investment amount: ");
        double amount = sc.nextDouble();
        System.out.print("Enter annual interest rate in percentage: ");
        double rate = sc.nextDouble();
        double monthlyRate = ((rate / 100.0) / 12.0);
        System.out.print("Enter number of years: ");
        double years = sc.nextDouble();
        double months = years * 12.0;
        
        double futureInvest = amount * Math.pow(monthlyRate + 1, months);

        System.out.printf("Accumulated value is $%.2f\n", futureInvest);
    }
}
