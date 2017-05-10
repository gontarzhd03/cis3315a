package chap3;

import java.util.Scanner;

/**
 * Compute the shipping costs
 *
 * @author Hank Gontarz
 */
public class P03N18ShippingCost {
    public void computeShipping() {
        double cost = 0.0;

        Scanner sc = new Scanner(System.in);
        System.out.println("***** Compute the shipping costs *****");
        System.out.print("Enter weight in pounds: ");
        double weight = sc.nextDouble();
        if (weight > 0 && weight <= 1) {
            cost = 3.5;
        } else if (weight > 1 && weight <= 3) {
            cost = 5.5;
        } else if (weight > 3 && weight <= 10) {
            cost = 8.5;
        } else if (weight > 10 && weight <= 20) {
            cost = 10.5;
        } 
/*
        else if (weight > 20 && weight <= 30) {
            cost = 13.5; //missing condition
        } else if (weight > 30 && weight <= 40) {
            cost = 15.5; //missing condition
        } else if (weight > 40 && weight < 50) {
            cost = 18.5; //missing condition
        } 
*/
        else if (weight > 20) {
            cost = -1.0;
        }
        if (cost < 0) {
            System.out.println("The package cannot be shipped.");
        } else {
            System.out.printf("The shipping cost is: $%.2f\n", cost);
        }
    }
    public static void main(String[] args) {
        P03N18ShippingCost shipping = new P03N18ShippingCost();
        shipping.computeShipping();
    }
}
