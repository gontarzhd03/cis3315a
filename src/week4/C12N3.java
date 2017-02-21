package week4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C12N3 {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(numbers.length);
        }
        System.out.print("Please choose an index number: ");
        int idx = sc.nextInt();
        try {
            System.out.println("Number: " + numbers[idx]);
        }
        catch(ArrayIndexOutOfBoundsException er) {
            System.out.println("Out of Bounds");
        }
    }
}
