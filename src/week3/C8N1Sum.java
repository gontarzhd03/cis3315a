package week3;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C8N1Sum {
    public static void main(String[] args) {
        double sum;
        double[][] values = {{0.0, 0.0, 0.0, 0.0},
                             {0.0, 0.0, 0.0, 0.0},
                             {0.0, 0.0, 0.0, 0.0}};
        

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 3-by-4 matrix row by row: ");
        for(int i = 0; i < values.length; i++) {
            String text = sc.nextLine();
            String[] numbers = text.split(" ");
            for(int j = 0; j < numbers.length; j++) {
                values[i][j] = Double.parseDouble(numbers[j]);
            }
        }
        
        for(int col = 0; col < values[0].length; col++) {
           sum = 0.0;
           for(int row = 0; row < values.length; row++) {
              sum += values[row][col];
           }
           System.out.printf("Sum of the elements at column %d is %.2f\n", col, sum);
        }
    }
}
