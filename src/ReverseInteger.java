

public class ReverseInteger {
    public static boolean overflow = false;

    public static void Solution() {
        int x = 1534236469;
        x = -901000;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        if (x == 0)
            return 0;
        if (x == Integer.MIN_VALUE)
            return 0;
        int sign = 1, digits;
        if (x < 0) {
            sign = -1;
            x *= -1;
        }
        digits = countDigits(x);
        int a = reverseUtil(x, digits);
        if (a < 0)
            return 0;
        return sign * a;
    }

    public static int reverseUtil(int x, int digits) {
        if (overflow)
            return 0;
        if (digits == 1)
            return x;
        int first = (new Double(x / (Math.pow(10, digits - 1)))).intValue();
        int r = reverseUtil((new Double(x % Math.pow(10, digits - 1))).intValue(), digits - 1);
        if (((double) r * 10) > Integer.MAX_VALUE) {
            overflow = true;
            return 0;
        }
        return r * 10 + first;
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