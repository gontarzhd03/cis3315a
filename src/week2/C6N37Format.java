package week2;

import java.util.Scanner;

/**
 * Two separate ways of formating a number into a string.
 * @author Hank Gontarz
 */
public class C6N37Format {
    public static String format(int number, int width) { //method 1
        String rc;
        String fmt;
        
        fmt = "%0" + String.format("%d", width) + "d";
        rc = String.format(fmt, number);
        return rc;
    }
    public static String format2(int number, int width) { //method 2
        String rc = "";
        String txt;
        
        txt = String.format("%d", number);
        if(width - txt.length() > 0) {
            int prefix = width - txt.length();
            for(int i = 0; i < prefix; i++) {
                rc += "0";
            }
        }
        rc += txt;
        return rc;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer number and the width to display: ");
        int number = sc.nextInt();
        int width = sc.nextInt();
        System.out.println(format(number, width));
        System.out.println(format2(number, width));
    }
}
