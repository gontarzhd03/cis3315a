package chap3;

import java.util.Scanner;

/**
 * Compute the body mass index.
 * @author Hank Gontarz
 */
public class L3N4BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Compute the BMI! *****");
        System.out.print("Enter the body weight (Pounds): ");
        double weight = sc.nextDouble();
        System.out.print("Enter the body height (Inches): ");
        double height = sc.nextDouble();

        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;
        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = height * METERS_PER_INCH;
        double bmi = weightInKilograms / (heightInMeters * heightInMeters);
        System.out.printf("BMI is %.4f\n", bmi);
        if(bmi < 18.5){
            System.out.println("Underweight");
        }
        else if(bmi < 25){
            System.out.println("Normal");
        }
        else if(bmi < 30){
            System.out.println("Overweight");
        }
        else {
            System.out.println("Obese");
        }
    }
}
