package chap4;

import java.util.Scanner;

/**
 * Create pig latin word
 * Vowels -> append "way"
 * Consonants -> move consonant letter to end & append "ay"
 * @author Hank Gontarz
 */
public class C04Pig {
    public static void main(String[] args) {
        String output;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Build a pig-latin word *****");
        System.out.print("Enter a word: ");
        String line = sc.nextLine();
        if(line.length() > 0) {
            switch(line.toLowerCase().charAt(0)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    output = line + "way";
                    break;
                default:
                    output = line.substring(1) + line.charAt(0) + "ay";
                    break;
            }
            System.out.println(output);
        }
        else {
            System.out.println("The word is missing!");
        }
    }
}
