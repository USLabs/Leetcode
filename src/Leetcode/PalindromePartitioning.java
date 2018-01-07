package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uslabs on 11/3/17.
 */
public class PalindromePartitioning {
    public static List<List<String>>[] dp;
    public static int[][] isPalin;

    public static void solution() {
        String str = "aabaa";
        dp = new List[str.length() + 1];
        isPalin = new int[str.length() + 1][str.length() + 1];
        List<List<String>> list = partitionUtil(str, 0);
        for (List<String> l : list) {
            System.out.print('[');
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<String>> partitionUtil(String s, int st) {
        if (dp[st] != null)
            return dp[st];
        dp[st] = new ArrayList<>();
        if (isPalin(s, st, s.length())) {
            List<String> l = new ArrayList<>();
            l.add(s.substring(st));
            dp[st].add(l);
        }

        for (int i = st + 1; i < s.length(); i++) {
            if (isPalin(s, st, i)) {
                dp[i] = partitionUtil(s, i);
                if (dp[i].size() != 0) {
                    for (List<String> list : dp[i]) {
                        List<String> temp = new ArrayList<>();
                        temp.add(0, s.substring(st, i));
                        temp.addAll(list);
                        dp[st].add(temp);
                    }
                }
            }
        }
        return dp[st];
    }

    private static boolean isPalin(String s, int i, int j) {
        if (isPalin[i][j] != 0)
            return isPalin[i][j] == 1;
        StringBuffer sb = new StringBuffer(s.substring(i, j));
        isPalin[i][j] = (s.substring(i, j).equals(sb.reverse().toString())) ? 1 : -1;
        return isPalin[i][j] == 1;
    }
}
