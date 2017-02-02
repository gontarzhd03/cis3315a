package week2;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C7N12Reverse {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter ten numbers: ");
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println(C7StatsStatic.toString(C7StatsStatic.reverse(numbers)));
    }
}
