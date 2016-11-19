import java.util.Arrays;

/**
 * Created by techmint on 11/1/16.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int[][] arr = new int[s.length()][s.length()];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (i == j)
                    arr[i][j] = 1;
                if (j == i + 1)
                    arr[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
            }
        }
        int l = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (arr[i][j] == 1) {
                    l = Math.max(l, j - i + 1);
                    result = i;
                    continue;
                }
                if (arr[i][j] == 0)
                {

                }
            }
        }
        return s.substring(result, result + l);
    }
}
