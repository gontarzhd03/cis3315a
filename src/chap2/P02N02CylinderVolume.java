/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap2;

import java.util.Scanner;

/**
 * Compute the volume of a cylinder. (Do 2.3 & 2.5)
 * @author Hank Gontarz
 */
public class P02N02CylinderVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius and length separated by a space: ");
        double radius = sc.nextDouble();
        double length = sc.nextDouble();
        
        double area = radius * radius * Math.PI;
        double volume = area * length;
        
        System.out.printf("The area is: \t%.4f\n", area);
        System.out.printf("The volume is: \t%.4f\n", volume);
        
        System.out.printf("%15s %7.4f\n", "The area is:", area);
        System.out.printf("%15s %7.4f\n", "The volume is:", volume);
    }
}
