package Leetcode;

/**
 * Created by techmint on 1/6/17.
 */
public class PalindromeNumber {
    public static void Solution() {
        int x = 214748364;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        return isPalindromeUtil(x, countDigits(x));
    }

    public static boolean isPalindromeUtil(int x, int digits) {
        if (digits == 0 || digits == 1)
            return true;

        int last = (new Double(x % Math.pow(10, 1))).intValue();
        int first = (new Double(x / (Math.pow(10, digits - 1)))).intValue();
        if (first != last)
            return false;
        x = (new Double(x / Math.pow(10, 1))).intValue();
        digits--;
        x = (new Double(x % Math.pow(10, digits - 1))).intValue();
        digits--;
        return isPalindromeUtil(x, digits);
    }

    public static int countDigits(int n) {
        int digits = 0;
        while (n > 0) {
            n /= 10;
            digits++;
        }
        return digits;
    }
}
