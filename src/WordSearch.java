import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by techmint on 11/18/16.
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            if (word.length() == 0)
                return true;
            else
                return false;
        }
        if (word.length() == 0)
            return true;
        int[][] status = new int[board.length][board[0].length];
        for (int[] row : status)
            Arrays.fill(row, 0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existUtil(board, status, word, i, j, ""))
                        return true;
                    for (int[] row : status)
                        Arrays.fill(row, 0);
                }
            }
        }
        return false;
    }

    public static boolean existUtil(char[][] board, int[][] status, String word, int i, int j, String dir) {
        if (word.length() == 0)
            return true;
        if (i < 0 || i >= board.length)
            return false;
        if (j < 0 || j >= board[i].length)
            return false;

        if (status[i][j] == 1) {
            return false;
        }

        if (board[i][j] == word.charAt(0)) {
            if (word.length() == 1)
                return true;
        } else
            return false;

        status[i][j] = 1;

        if (dir != "up" && i > 0 && existUtil(board, status, word.substring(1), i - 1, j, "down"))
            return true;
        if (dir != "down" && i < (board.length - 1) && existUtil(board, status, word.substring(1), i + 1, j, "up"))
            return true;
        if (dir != "left" && j > 0 && existUtil(board, status, word.substring(1), i, j - 1, "right"))
            return true;
        if (dir != "right" && j < (board[i].length - 1) && existUtil(board, status, word.substring(1), i, j + 1, "left"))
            return true;

        status[i][j] = 0;
        return false;
    }
}
