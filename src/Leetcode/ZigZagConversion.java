package Leetcode;

import java.util.Arrays;

/**
 * Created by uslabs on 6/7/17.
 */
public class ZigZagConversion {
    public static void solution(String str, int n) {

    /*
        ABCDE
        2

        A C E
        B   D

    */

    /*
        P   I   N   E
        A A S R G U N
        Y   H   S   T
        P L I I T D S
    */
        char[][] matrix = new char[n][(2 * str.length() / (n + n - 2)) + 1];

        int row = 0, pos = 0;
        boolean reverse = false, done = false;
        for (int col = 0; col < matrix[0].length; col++) {
            if (done)
                break;
            if (!reverse) {
                while (row < n) {
                    if (pos >= str.length()) {
                        done = true;
                        break;
                    }
                    if (col % 2 == 0)
                        matrix[row][col] = str.charAt(pos++);
                    else {
                        if (row != n - 1 || row != 0)
                            matrix[row][col] = str.charAt(pos++);
                    }
                    row++;
                }
                row = n - 1;
                reverse = true;
            } else {
                while (row >= 0) {
                    if (pos >= str.length()) {
                        done = true;
                        break;
                    }
                    if (col % 2 == 0)
                        matrix[row][col] = str.charAt(pos++);
                    else {
                        if (!((row == n - 1) || (row == 0)))
                            matrix[row][col] = str.charAt(pos++);
                    }
                    row--;
                }
                row = 0;
                reverse = false;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0)
                    sb.append(matrix[i][j]);
            }
        }
        String result = sb.toString();
        System.out.println(result);
    }
}