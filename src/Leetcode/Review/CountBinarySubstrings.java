package Leetcode.Review;

/**
 * Created by uslabs on 10/26/17.
 */
public class CountBinarySubstrings {
    public static void solution() {
        System.out.println(countBinarySubstrings("00110"));
    }

    public static int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }
}