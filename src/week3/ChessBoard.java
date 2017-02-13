package week3;

/**
 *
 * @author Hank Gontarz
 */
public class ChessBoard {
    protected char[][] board;
    protected int count;
    
    public ChessBoard() {
        reset();
    }
    public void move(int rowFrom, int colFrom, int rowTo, int colTo) {
        board[rowTo][colTo] = board[rowFrom][colFrom];
        board[rowFrom][colFrom] = '-';
        count++;
    }
    public void reset() {
        char[][] tempBoard = {
            {' ', '1', '2', '3', '4', '5', '6', '7', '8'},
            {'1', 'r', 'h', 'b', 'q', 'k', 'b', 'h', 'r'},
            {'2', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'3', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'4', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'5', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'6', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'7', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'8', 'R', 'H', 'B', 'Q', 'K', 'B', 'H', 'R'}
        };
        this.board = tempBoard;
        count = 0;
    }
    public char getPiece(int row, int col) {
        return board[row][col];
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                sb.append(board[row][col]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
