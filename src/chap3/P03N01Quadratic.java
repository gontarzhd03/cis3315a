package chap3;

import java.util.Scanner;

/**
 * Compute the quadratic equations
 *
 * @author Hank Gontarz
 */
public class P03N01Quadratic {
    public void computeQuadratic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Compute A Quadratic Equation! *****");
        System.out.print("Enter a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double discriminant = (b * b) - 4 * a * c;
        if (discriminant > 0.0) {
            double r1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            double r2 = (-b - Math.sqrt(discriminant)) / 2 * a;
            System.out.printf("The equation has two roots %.6f and %.6f\n", r1, r2);
        } else if (discriminant == 0.0) {
            double r1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            System.out.printf("The equation has one root %.6f\n", r1);
        } else {
            System.out.printf("The equation has no real roots\n");
        }
    }
    public static void main(String[] args) {
        P03N01Quadratic quad = new P03N01Quadratic();
        quad.computeQuadratic();
    }
}
