package chap5;

import java.util.Scanner;

/**
 * Test different loops
 *
 * @author Hank Gontarz
 */
public class Loops1 {

    public static void main(String[] args) {
        int count = 0;
        while (count <= 10) {
            System.out.println("The count is: " + count);
            count += 2;
        }
        Scanner sc = new Scanner(System.in);
        String answer = "y";
        while (answer.equalsIgnoreCase("Y")) {
            System.out.println("Hello");
            System.out.print("Loop again? y/n");
            answer = sc.nextLine();
        }
        for (int count2 = 0; count2 <= 10; count2 += 2) {
            System.out.println("The count is: " + count2);
        }
        for (int row = 1; row < 10; row++) {
            for (int col = 1; col < 10; col++) {
                System.out.printf("%6d", row * col);
            }
            System.out.println("");
        }
    }
}
