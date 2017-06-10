

public class ReverseInteger {
    public static void Solution(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -sign;
            x = -x;
        }

        int y;
        long a = 0;
        while (x > 0) {
            a = a * 10 + x % 10;
            x /= 10;
        }

        if (a > Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }

        int b = (int) (sign * a);
        System.out.println(b);
    }
}