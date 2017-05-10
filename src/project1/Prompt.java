package project1;

import java.util.Scanner;

/**
 * Prompt is a class that gets console input from the user, validates the input,
 * and then returns the result.
 *
 * @author Hank Gontarz
 */
public class Prompt {

    public static int getInt(String prompt) {
        boolean isValid = false;
        int i = 0;

        Scanner sc = new Scanner(System.in);
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        boolean isValid = false;
        int i = 0;

        while (!isValid) {
            i = getInt(prompt);
            if (i < min) {
                System.out.println("\nError! Integer value must be greater than or equal to: " + min);
            } else if (i > max) {
                System.out.println("\nError! Integer value must be less than or equal to: " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }
    public static double getDouble(String prompt) {
        boolean isValid = false;
        double d = 0;
        
        Scanner sc = new Scanner(System.in);
        while (!isValid) {
            System.out.print(prompt);
            if(sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            }
            else {
                System.out.println("\nError! Invalid double value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }
    public static double getInt(String prompt, double min, double max) {
        boolean isValid = false;
        double i = 0;

        while (!isValid) {
            i = getDouble(prompt);
            if (i < min) {
                System.out.println("\nError! Integer value must be greater than or equal to: " + min);
            } else if (i > max) {
                System.out.println("\nError! Integer value must be less than or equal to: " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }
    public static String getLine(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextLine();
    }
}
