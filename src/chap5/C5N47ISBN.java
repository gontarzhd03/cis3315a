package chap5;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C5N47ISBN {
    public static void main(String[] args) {
        int checkSum = 0;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
            String text = sc.nextLine();
            if(text.length() >= 12) {
                for(int i = 1; i <= text.length(); i++) {
                    String digit = text.substring(i-1, i);
                    int value = Integer.parseInt(digit);
                    if(i % 2 == 0) {
                        checkSum += value * 3;
                    }
                    else {
                        checkSum += value;
                    }
                }
                int rc = 10 - (checkSum % 10);
                if(rc == 10) rc = 0;
                System.out.printf("The ISBN-13 number is %s%d\n", text, rc);
                break;
            }
            else {
                System.out.println(text + " is an invalid input!");
            }
        } while(true);
    }
}
