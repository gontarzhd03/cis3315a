
package chap2;

import java.util.Scanner;

/**
 *
 * @author 55gontarhd03
 */

public class P01ComputeArea {

    public static void main(String[] args) {
        double radius;
        double area;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        radius = sc.nextDouble();

        area = radius * radius * Math.PI;
        System.out.println("The area for the circle of radius "
                + radius + " is " + area);
        
    }
}
