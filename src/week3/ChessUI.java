package week3;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class ChessUI {
    public static void main(String[] args) {
        int count = 0;
        int[] rowcol = {0, 0, 0, 0};
        ChessBoard chess = new ChessBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to chess game!");
        System.out.println("Pieces use a row and column number");
        System.out.println("Enter a starting position followed by an ending position");
        System.out.println(chess.toString());
        do {
            if(count % 2 == 0) {
                System.out.print("White - From, To: ");
            }
            else {
                System.out.print("Black - From, To: ");
            }
            String rowcolStr = sc.nextLine();
            if(rowcolStr.equals("quit")) break;
            String[] numbers = rowcolStr.split(" ");
            if(numbers.length >= 4) {
                for(int j = 0; j < rowcol.length; j++) {
                    rowcol[j] = Integer.parseInt(numbers[j]);
                }
                if(rowcol[0] != 0 && chess.getPiece(rowcol[0], rowcol[1]) != '-') {
                    chess.move(rowcol[0], rowcol[1], rowcol[2], rowcol[3]);
                    System.out.println("");
                    System.out.println(chess.toString());
                    count++;
                }
                else {
                    System.out.println("Invalid move!");
                }
            }
            else {
               System.out.println("You missed a number!");
            }
        } while(true);
    }
}
