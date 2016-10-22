import java.util.ArrayList;
import java.util.List;

/**
 * Created by techmint on 10/19/16.
 */
public class NQueens {

    public static void printList(List<List<String>> sols) {
        for (List<String> sol : sols) {
            for (String str : sol)
                System.out.println(str);
            System.out.println();
        }
    }

    public static void reset(List<String> sol, int row, int col, int n) {
        for (int i = row; i < n; i++) {
            for (int j = col; j < n; j++) {
                sol.set(row, sol.get(row).substring(0, col) + '.' + sol.get(row).substring(col + 1));
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {

        List<String> sol = new ArrayList<String>();

        String str = "";

        for (int i = 0; i < n; i++) {
            str += ".";
        }

        for (int i = 0; i < n; i++) {
            sol.add(new String(str));
        }

        List<List<String>> sols = new ArrayList<List<String>>();
        solveNQueensUtil(sols, sol, 0, 0, n, 1);
        // printList(sols);
        System.out.println(sols.size());
        return sols;
    }

    public static boolean isSafe(int a, int b, List<String> sol, int n) {
        if (a >= n || b >= n)
            return false;
        if (sol.get(a).charAt(b) == 'Q')
            return false;
        for (int i = a - 1; i >= 0; i--) {
            if (sol.get(i).charAt(b) == 'Q')
                return false;

            if ((b - (a - i)) >= 0) {
                if (sol.get(i).charAt(b - (a - i)) == 'Q')
                    return false;
            }

            if ((b + a - i) < n) {
                if (sol.get(i).charAt(b + (a - i)) == 'Q')
                    return false;
            }
        }

        for (int j = 0; j < a; j++) {
            if (sol.get(a).charAt(j) == 'Q')
                return false;
        }
        return true;
    }

    public static boolean solveNQueensUtil(List<List<String>> sols, List<String> sol, int row, int col, int n, int reclevel) {
        if (row >= n || col >= n)
            return true;
        for (; col < n; col++) {
            if (isSafe(row, col, sol, n)) {
                sol.set(row, sol.get(row).substring(0, col) + 'Q' + sol.get(row).substring(col + 1));
                if ((solveNQueensUtil(sols, sol, row + 1, 0, n, reclevel + 1)) && (reclevel == n)) {
                    List<String> nextsol = new ArrayList<>(sol);
                    sols.add(nextsol);
                    reset(sol, row, col, n);
                    if ((col + 1) < n)
                    {
                        solveNQueensUtil(sols, sol, row, col + 1, n, reclevel + 1);
                        reset(sol, row, col, n);
                    }
                    else {
                        if ((row + 1) < n)
                            solveNQueensUtil(sols, sol, row + 1, 0, n, reclevel + 1);
                    }
                    return true;
                }
                sol.set(row, sol.get(row).substring(0, col) + '.' + sol.get(row).substring(col + 1));
            }
        }
        return false;
    }
}