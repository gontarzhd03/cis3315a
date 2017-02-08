package week3;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class ChessUI {
    public static void main(String[] args) {
        int[] rowcol = {0, 0, 0, 0};
        ChessBoard chess = new ChessBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to chess game!");
        System.out.println("Pieces use a row and column number");
        System.out.println("Enter a starting position followed by an ending position");
        System.out.println(chess.toString());
        do {
            System.out.print("From, To: ");
            String rowcolStr = sc.nextLine();
            if(rowcolStr.equals("quit")) break;
            String[] numbers = rowcolStr.split(" ");
            if(numbers.length >= 4) {
                for(int j = 0; j < rowcol.length; j++) {
                    rowcol[j] = Integer.parseInt(numbers[j]);
                }
                chess.move(rowcol[0], rowcol[1], rowcol[2], rowcol[3]);
                System.out.println("");
                System.out.println(chess.toString());
            }
            else {
               System.out.println("You missed a number!");
            }
        } while(true);
    }
}
