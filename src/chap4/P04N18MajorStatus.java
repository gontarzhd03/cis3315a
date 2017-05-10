package chap4;

import java.util.Scanner;

/**
 * Query student major and status
 * @author Hank Gontarz
 */
public class P04N18MajorStatus {
    public static void main(String[] args) {
        String output;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Query student major and status *****");
        System.out.println("M: Mathematics; C: Computer Science; I: Information Technology");
        System.out.println("1: Freshman; 2: Sophomore; 3: Junior; 4: Senior");
        System.out.print("Enter a major & status: ");
        String line = sc.nextLine();
        if(line.length() > 1) {
            line = line.toLowerCase();
            switch(line.charAt(0)) {
                case 'm':
                    output = "Mathematics ";
                    break;
                case 'c':
                    output = "Computer Science ";
                    break;
                case 'i':
                    output = "Information Technology ";
                    break;
                default:
                    output = "Invalid Input ";
                    break;
            }
            switch(line.charAt(1)) {
                case '1':
                    output += "Freshman";
                    break;
                case '2':
                    output += "Sophomore";
                    break;
                case '3':
                    output += "Junior";
                    break;
                case '4':
                    output += "Senior";
                    break;
                default:
                    output = "Invalid Input";
                    break;
            }
            System.out.println(output);
        }
        else {
            System.out.println("Invalid Input!");
        }
    }
}
