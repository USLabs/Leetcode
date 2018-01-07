package Leetcode;

/**
 * Created by uslabs on 6/11/17.
 */
public class CountingBits {
    public static int[] Solution() {
        int num = 10;
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
