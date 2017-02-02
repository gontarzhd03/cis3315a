package week2;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class C5N49Count {
    public static void main(String[] args) {
        int vowels = 0;
        int conconants = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        text = text.toLowerCase();
        for(int i = 0; i < text.length(); i++) {
            char cc = text.charAt(i);
            if(Character.isLetter(cc)) {
                switch(cc) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowels++;
                        break;
                    default:
                        conconants++;
                        break;
                }
            }
        }
        System.out.printf("The number of vowels are %d, consonants are %d\n", vowels, conconants);
    }
}
