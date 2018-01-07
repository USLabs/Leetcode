package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uslabs on 11/1/17.
 */
public class WordBreak {
    public static void solution() {
        String s = "bccdbacdbdacddabbaaaadababadad";
        String[] arr = {"cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"};
        List<String> list = new ArrayList<>();
        for(String ss :arr){
            list.add(ss);
        }
        System.out.println(wordBreak(s, list));
    }

    private static int[][] dp;
    private static String str;

    public static boolean wordBreak(String s, List<String> list) {
        dp = new int[s.length() + 1][s.length() + 1];
        str = s;
        return util(0, str.length(), list);
    }

    public static boolean util(int ii, int jj, List<String> list) {
        if (ii > jj)
            return false;

        if (dp[ii][jj] != 0) {
            return dp[ii][jj] == 1 ? true : false;
        }
        String t = str.substring(ii, jj);
        if (t.length() == 0) {
            dp[ii][jj] = 1;
            return true;
        }
        for (String s : list) {
            if (s.equals(t)) {
                dp[ii][jj] = 1;
                return true;
            }
            int index = t.indexOf(s);
            if (index != -1) {
                if (util(ii, ii + index, list) && util(ii + index + s.length(), jj, list)) {
                    dp[ii][jj] = 1;
                    return true;
                }
            }
        }
        dp[ii][jj] = -1;
        return false;
    }
}