package Leetcode.Review;

/**
 * Created by uslabs on 11/1/17.
 */
public class Pow {
    public static void solution() {
        System.out.println(myPow(8.88023, 3));
    }

    public static double myPow(double x, int n) {
        if(n==0)
            return 1;
        if( n < 0 ) {
            if( n == Integer.MIN_VALUE ) {
                ++n;
                n = -n;
                x = 1/x;
                return x * x * myPow( x * x, n / 2 );
            }
            n = -n;
            x = 1 / x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}