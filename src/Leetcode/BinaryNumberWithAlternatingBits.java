package Leetcode;

/**
 * Created by uslabs on 10/11/17.
 */
public class BinaryNumberWithAlternatingBits {
    public static boolean hasAlternatingBits(int n) {

        String s = Integer.toBinaryString(n);
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev)
                return false;
            if (prev == '0')
                prev = '1';
            else
                prev = '0';

        }
        return true;
    }
}
