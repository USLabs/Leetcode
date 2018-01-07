package Leetcode;

/**
 * Created by uslabs on 10/29/17.
 */
public class SetMatrixZeroes {
    public static void solution() {
        int[][] m = {{0, 1}};
        setZeroes(m);;

    }

    public static void setZeroes(int[][] m) {
        int[] rows = new int[m.length], cols = new int[m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        set(m, rows, cols);
    }

    public static void set(int[][] m, int[] rows, int[] cols) {
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 1) {
                for (int j = 0; j < m[0].length; j++)
                    m[i][j] = 0;
            }
        }

        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 1) {
                for (int j = 0; j < m.length; j++)
                    m[j][i] = 0;
            }
        }
    }
}