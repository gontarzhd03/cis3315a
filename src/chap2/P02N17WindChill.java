/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap2;

import java.util.Scanner;

/**
 * Compute the wind-chill temperature
 * @author Hank Gontarz
 */
public class P02N17WindChill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the temperature in Fahrenheit between -58F and 41F: ");
        double temp = sc.nextDouble();
        System.out.print("Enter the wind speed (>-2) in miles per hour: ");
        double speed = sc.nextDouble();

        //windchill = 35.74 + 0.6215*temp - 35.75*speed pow(0.16) + 0.4275*temp*speed pow(0.16)
        double windchill = 35.74 + (0.6215 * temp) - Math.pow(speed, 0.16) * 35.75 + Math.pow(speed, 0.16) * 0.4275 * temp;

        System.out.printf("The wind chill index is: %.4f\n", windchill);
    }
}
