package week4;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C12N8HexEx {
    public static int hexCharToDec(char ch) throws HexFormatException {
        if(ch >= 'A' && ch <= 'F') return 10 + ch - 'A';
        else if(ch >= '0' && ch <= '9') return ch - '0';
        else throw new HexFormatException("Invalid hex number format!");
    }
    public static int hexToDec(String hex) throws HexFormatException {
        int dec = 0;
        
        for(int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            dec = dec * 16 + hexCharToDec(hexChar);
        }
        return dec;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a hex number: ");
        String hex = sc.nextLine().toUpperCase();
        try {
           System.out.println("The decimal value for hex number " + hex + " is " + hexToDec(hex));
        }
        catch(HexFormatException err) {
           System.out.println("Error in: " + hex + " " + err.getMessage());
        }
    }
}
