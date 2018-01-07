package Leetcode;

/**
 * Created by uslabs on 10/5/17.
 */
public class KnightProbabilityInChessboard {

    public static int n, k;
    public static double[][][] dp;
    public static int[][] d = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}};

    public static double knightProbability(int N, int K, int r, int c) {
        n = N;
        k = K;
        dp = new double[n][n][k + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int u = 0; u <= k; ++u) {
                    dp[i][j][u] = -1;
                }
            }
        }
        double d = solve(r, c, k);
        return d;
    }


    public static double ret;

    public static double solve(int x, int y, int k) {
        if (x < 0 || x >= n || y < 0 || y >= n)
            return 0;
        ret = dp[x][y][k];
        if (ret >= 0)
            return ret;
        if (k == 0) return ret = 1;
        ret = 0;
        for (int i = 0; i < 8; ++i) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            ret += 1.0 / 8 * solve(nx, ny, k - 1);
        }
        return ret;
    }
}
