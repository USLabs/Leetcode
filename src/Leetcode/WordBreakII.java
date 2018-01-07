package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by uslabs on 11/4/17.
 */
public class WordBreakII {
    public static void solution() {
        //String s = "catsanddog";
        //String[] dict = {"cat", "cats", "and", "sand", "dog"};
        String s = "aaaaaaa";
        String[] dict = {"aaaa", "aa", "a"};
        List<String> list = wordBreak(s, Arrays.asList(dict));
        for (String ss : list) {
            System.out.println(ss);
        }

        System.out.println("------------------------------------");
        System.out.println("a a a a a a a");
        System.out.println("aa a a a a a");
        System.out.println("a aa a a a a");
        System.out.println("a a aa a a a");
        System.out.println("aa aa a a a");
        System.out.println("aaaa a a a");
        System.out.println("a a a aa a a");
        System.out.println("aa a aa a a");
        System.out.println("a aa aa a a");
        System.out.println("a aaaa a a");
        //"a a a a aa a","aa a a aa a","a aa a aa a","a a aa aa a","aa aa aa a","aaaa aa a","a a aaaa a","aa aaaa a","a a a a a aa","aa a a a aa","a aa a a aa","a a aa a aa","aa aa a aa","aaaa a aa","a a a aa aa","aa a aa aa","a aa aa aa","a aaaa aa","a a a aaaa","aa a aaaa","a aa aaaa"]
    }

    private static List<String>[] dp;

    public static List<String> wordBreak(String s, List<String> wordDict) {
        dp = new ArrayList[s.length() + 1];
        return wordBreakUtil(s, wordDict, 0);
    }

    private static List<String> wordBreakUtil(String s, List<String> wordDict, int st) {
        if (dp[st] != null)
            return dp[st];
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = st; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                if (i == s.length() - 1) {
                    result.add(s.substring(st));
                } else {
                    dp[i + 1] = wordBreakUtil(s, wordDict, i + 1);
                    if (dp[i + 1] != null && dp[i + 1].size() != 0) {
                        for (String str : dp[i + 1]) {
                            result.add(sb + " " + str);
                        }
                    }
                }
            }
        }
        dp[st] = result;
        return dp[st];
    }
}