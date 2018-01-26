package Twitter;

import java.util.Arrays;

/**
 * Created by uslabs on 11/27/17.
 */
public class TwitterLongestPhrasesInATweet {
    public static void solution() {
        int[] arr = {
                61,
                74,
                659,
                931,
                273,
                545,
                879,
                924,
                710,
                441,
                166,
                493,
                43,
                988,
                504,
                328,
                730,
                841,
                613,
                304,
                170,
                710,
                158,
                561,
                934,
                100,
                279,
                817,
                336,
                98,
                827,
                513,
                268,
                811,
                634,
                980,
                150,
                580,
                822,
                968,
                673,
                394,
                337,
                486,
                746,
                229,
                92,
                195,
                358,
                2,
                154,
                709,
                945,
                669,
                491,
                125,
                197,
                531,
                904,
                723,
                667,
                550};
        int k = 22337;
        System.out.println(maxLength(arr, k));
        // Output : 46
    }

    private static int maxLength(int[] arr, int k) {
        dp = new int[arr.length + 1][k + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, util(arr, k, i));
        }
        return max;
    }

    private static int[][] dp;

    private static int util(int[] arr, int k, int a) {

        if (a > arr.length - 1 || k <= 0)
            return 0;
        if (dp[a][k] != -1) {
            return dp[a][k];
        }
        if (arr[a] > k)
            return 0;

        dp[a][k] = 1 + util(arr, k - arr[a], a + 1);

        return dp[a][k];
    }
}