package Leetcode;

import java.util.Arrays;/**
 * Created by techmint on 11/1/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        int[] buff = new int[128];
        Arrays.fill(buff, -1);
        int l = 0, maxim = 0;
        for (int st = 0; st < s.length(); st++) {
            l = 0;
            for (int i = st; i < s.length(); i++) {
                if (buff[s.charAt(i)] == -1) {
                    buff[s.charAt(i)] = i;
                    l++;
                } else {
                    st = buff[s.charAt(i)];
                    break;
                }
            }
            maxim = Math.max(maxim, l);
            Arrays.fill(buff, -1);
        }
        return maxim;
    }
}
