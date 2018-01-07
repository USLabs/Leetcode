package Leetcode;

import java.util.Arrays;

/**
 * Created by uslabs on 11/4/17.
 */
public class PalindromePartitioningII {
    public static void solution() {
        System.out.println(minCut("ababbbabbababa"));
    }

    private static int[] dp;
    private static int[][] palin;

    public static int minCut(String s) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        palin = new int[s.length() + 1][s.length() + 1];
        if (s.length() == 0)
            return 0;
        return minCutUtil(s, 0);
    }

    private static int minCutUtil(String s, int st) {
        if (st >= s.length())
            return 0;

        if (dp[st] != -1)
            return dp[st];

        if (isPalindrome(s, st, s.length())) {
            dp[st] = 0;
            return dp[st];
        }
        int min = Integer.MAX_VALUE;
        for (int i = st + 1; i < s.length(); i++) {
            if (isPalindrome(s, st, i)) {
                dp[i] = minCutUtil(s, i);
                min = Math.min(min, 1 + dp[i]);
            }
        }
        dp[st] = min;
        return dp[st];
    }

    private static boolean isPalindrome(String s, int i, int j) {
        if (i == j - 1 || i == j) {
            palin[i][j] = 1;
        } else {
            if (palin[i][j] == 0) {
                if (s.charAt(i) == s.charAt(j - 1)) {
                    palin[i][j] = isPalindrome(s, i + 1, j - 1) ? 1 : -1;
                } else
                    palin[i][j] = -1;
            }
        }
        return palin[i][j] == 1;
    }
}
