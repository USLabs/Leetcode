package Leetcode;

/**
 * Created by uslabs on 6/11/17.
 */
public class BattleshipInABoard {
    public static int Solution() {
        char[][] board = getBoard();
        //char[][] board = {{'X', '.', '.', 'X'}, {'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        if (board == null || board.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0) {
                        if (j == 0)
                            count++;
                        else if (board[i][j - 1] != 'X')
                            count++;
                    } else {
                        if (j == 0) {
                            if (board[i - 1][j] != 'X')
                                count++;
                        } else if (board[i - 1][j] != 'X' && board[i][j - 1] != 'X')
                            count++;

                    }
                }
            }
        }
        return (count);
    }

    static char[][] getBoard() {
        char[][] board = new char[3][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        board[0][0] = 'x';
        board[0][3] = 'x';
        board[1][3] = 'x';
        board[2][3] = 'x';
        return board;
    }
}