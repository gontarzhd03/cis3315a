package chap2;

import java.util.Scanner;

/**
 * Compute the cost of driving a vehicle.
 * @author Hank Gontarz
 */
public class P02N23DrivingCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Compute the cost of driving! *****");
        System.out.print("Enter the driving distance: ");
        double distance = sc.nextDouble();
        System.out.print("Enter miles per gallon: ");
        double mpg = sc.nextDouble();
        System.out.print("Enter price per gallon: ");
        double ppg = sc.nextDouble();

        double cost = (distance / mpg) * ppg;

        System.out.printf("The cost of driving is $%.2f\n", cost);
    }
}
