package chap7;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C7N20Sort {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter ten decimal numbers: ");
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextDouble();
        }
        C7StatsStatic.selectionSortInc(numbers);
        System.out.println(C7StatsStatic.toString(numbers));
        C7StatsStatic.selectionSortDec(numbers);
        System.out.println(C7StatsStatic.toString(numbers));
    }
}
