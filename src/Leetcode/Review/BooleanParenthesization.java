package Leetcode.Review;

/**
 * Created by uslabs on 11/9/17.
 */
public class BooleanParenthesization {
    public static void solution() {
        char[] arr1 = {'T', 'F'}, arr2 = {'&', '|', '^'};
        System.out.println(countParenth(arr1, arr2));
    }

    static int[][] T, F;
    static char[] symb, oper;

    public static int countParenth(char[] s, char[] o) {
        symb = s;
        oper = o;
        T = new int[s.length][symb.length];
        F = new int[s.length][symb.length];
        return util(symb.length);
    }

    public static int util(int n) {

        for (int i = 0; i < n; i++) {
            F[i][i] = (symb[i] == 'F') ? 1 : 0;
            T[i][i] = (symb[i] == 'T') ? 1 : 0;
        }

        // Now fill T[i][i+1], T[i][i+2], T[i][i+3]... in order
        // And F[i][i+1], F[i][i+2], F[i][i+3]... in order
        for (int gap = 1; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                T[i][j] = F[i][j] = 0;
                for (int g = 0; g < gap; g++) {
                    // Find place of parenthesization using current value
                    // of gap
                    int k = i + g;

                    // Store Total[i][k] and Total[k+1][j]
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k + 1][j] + F[k + 1][j];

                    // Follow the recursive formulas according to the current
                    // operator
                    if (oper[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
                    }
                    if (oper[k] == '|') {
                        F[i][j] += F[i][k] * F[k + 1][j];
                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
                    }
                    if (oper[k] == '^') {
                        T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        return T[0][n - 1];
    }
}
