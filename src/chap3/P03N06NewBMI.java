package chap3;

import java.util.Scanner;

/**
 * Compute the body mass index.
 *
 * @author Hank Gontarz
 */
public class P03N06NewBMI {
    public void computeBMI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Compute the BMI! *****");
        System.out.print("Enter weight in pounds: ");
        double weight = sc.nextDouble();
        System.out.print("Enter feet: ");
        double feet = sc.nextDouble();
        System.out.print("Enter inches: ");
        double inches = sc.nextDouble();
        double height = (feet * 12) + inches;

        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;
        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = height * METERS_PER_INCH;
        double bmi = weightInKilograms / (heightInMeters * heightInMeters);
        System.out.printf("BMI is %.4f\n", bmi);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
    public static void main(String[] args) {
        P03N06NewBMI bmi = new P03N06NewBMI();
        bmi.computeBMI();
    }
}
