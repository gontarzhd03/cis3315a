package week2;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C5N46RevString {
    public static void main(String[] args) {
        String rc = "";
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        for(int i = text.length()-1; i >= 0; i--) {
            rc += text.charAt(i);
        }
        System.out.println("The reversed string is: " + rc);
    }
}
