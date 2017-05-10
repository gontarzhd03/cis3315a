package chap3;

import java.util.Random;
import java.util.Scanner;

/**
 * Implement scissors, rock, paper game
 *
 * @author Hank Gontarz
 *
 * scissors, rock (rock wins) scissors, paper (scissors wins) rock, paper (paper wins)
 * rock, scissors (rock wins) paper, scissors (scissors wins) paper, rock (paper wins)
 */
public class P03N17ScissorRockPaper {

    public String getWeaponStr(int weapon) {
        String str1 = "";
        switch (weapon) {
            case 0:
                str1 = "scissor";
                break;
            case 1:
                str1 = "rock";
                break;
            case 2:
                str1 = "paper";
                break;
        }
        return str1;
    }

    public void startGame() {
        String result = "";
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int computerChoice = rand.nextInt(3);
        System.out.println("***** Lets play scissors, rock, paper! *****");
        System.out.print("scissor (0), rock (1), paper (2): ");
        int humanChoice = sc.nextInt();
        result = "The computer is " + getWeaponStr(computerChoice) + ". You are " + getWeaponStr(humanChoice);
        if (computerChoice == humanChoice) {
            result += " too. It is a draw";
        } else if (computerChoice == 0 && humanChoice == 1) {
            result += ". You won";
        } else if (computerChoice == 1 && humanChoice == 2) {
            result += ". You won";
        } else if (computerChoice == 2 && humanChoice == 0) {
            result += ". You won";
        } else if (computerChoice == 0 && humanChoice == 2) {
            result += ". You loose";
        } else if (computerChoice == 1 && humanChoice == 0) {
            result += ". You loose";
        } else if (computerChoice == 2 && humanChoice == 1) {
            result += ". You loose";
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        P03N17ScissorRockPaper srp = new P03N17ScissorRockPaper();
        srp.startGame();
    }
}
