package week2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class Guess {

    /**
     * @param args the command line arguments
     */
//guess    1 - 10
    public void StartGuess() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int num = rd.nextInt(10) + 1;
        System.out.print("Hanks guessing game.");
        do {
            System.out.print("Please enter a number from 1 - 10: ");
            int guess = sc.nextInt();
            if(guess == num) {
                System.out.println("You got it!");
                System.out.print("Would you like to play again? (1/0) ");
                if(sc.nextInt() == 0) {
                    break;
                }
            }
            else if(guess > num) {
                System.out.println("Your number is too high, try again!");
            }
            else {
                System.out.println("Your number is too low, try again!");
            }
        } while(true);
    }
    public static void main(String[] args) {
         new Guess().StartGuess();
    }
}
