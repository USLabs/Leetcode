/**
 * Created by uslabs on 6/7/17.
 */
public class ZigZagConversion {
    public static void solution(String str, int nRows) {

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
        int k = 0;
        int nCols = str.length() / nRows * 2;
        if (nCols == 0)
            nCols++;
        char[][] arr = new char[nRows][nCols];
        for (int j = 0; j < nCols && k < str.length(); j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < nRows && k < str.length(); i++) {
                    arr[i][j] = str.charAt(k);
                    k++;
                }
            } else {
                if (nRows == 2) {
                    for (int i = nRows - 2; i >= 0 && k < str.length(); i -= 1) {
                        arr[i][j] = str.charAt(k);
                        k++;
                    }
                } else {
                    for (int i = nRows - 2; i > 0 && k < str.length(); i -= 1) {
                        arr[i][j] = str.charAt(k);
                        k++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < nCols; j++) {
                if (arr[i][j] != '\u0000')
                    sb.append(arr[i][j]);
            }
        }
        System.out.println(sb.toString());
    }
}
