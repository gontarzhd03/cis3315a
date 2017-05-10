/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap7;

import java.util.Scanner;

/**
 *
 * @author 55gontarhd03
 */
public class C7N01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many scores: ");
        int n = sc.nextInt();
        int[] myNums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score: ");
            myNums[i] = sc.nextInt();
        }
        int best = myNums[0];
        for (int i = 1; i < n; i++) {
            if (myNums[i] > best) {
                best = myNums[i];
            }
        }
        System.out.println("The best score is: " + best);
        for (int i = 0; i < n; i++) {
            if (myNums[i] >= best - 10) {
                System.out.println(myNums[i] + " is an A");
            } else if (myNums[i] >= best - 20) {
                System.out.println(myNums[i] + " is an B");
            } else if (myNums[i] >= best - 30) {
                System.out.println(myNums[i] + " is an C");
            } else if (myNums[i] >= best - 40) {
                System.out.println(myNums[i] + " is an D");
            } else {
                System.out.println(myNums[i] + " is an F");
            }
        }
    }
}
