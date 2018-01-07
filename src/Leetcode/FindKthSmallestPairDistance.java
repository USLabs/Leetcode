package Leetcode;

import java.util.Arrays;

/**
 * Created by uslabs on 10/28/17.
 */
public class FindKthSmallestPairDistance {
    public static void solution() {
        int[] nums = {9, 10, 7, 10, 6, 1, 5, 4, 9, 8};
        int k = 18;
        System.out.println(smallestDistancePair(nums, k));
    }

    public static int[][][] dp;

    public static int smallestDistancePair(int[] arr, int k) {
        int total = arr.length * (arr.length - 1) / 2;
        dp = new int[arr.length + 1][arr.length + 1][total + 1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return largestDistancePair(arr, total - k, 0, arr.length - 1);
    }

    public static int largestDistancePair(int[] arr, int k, int ii, int jj) {
        Arrays.sort(arr);

        if (ii >= jj)
            return -1;

        if (dp[ii][jj][k] != -1)
            return dp[ii][jj][k];

        if (k == 0) {
            dp[ii][jj][k] = Math.abs(arr[ii] - arr[jj]);
            return dp[ii][jj][k];
        }

        dp[ii][jj][k] = Math.max(largestDistancePair(arr, k - 1, ii + 1, jj), largestDistancePair(arr, k - 1, ii, jj - 1));
        return dp[ii][jj][k];

        /*
        int i = ii, j = jj, x = ii + 1, y = jj - 1;
        k--;
        for (; i <= j && k > 0; ) {

            int a = Math.abs(arr[i] - arr[y]);
            int b = Math.abs(arr[x] - arr[j]);
            while(a > b) {
                int c = Math.abs(i+1)
                j--;
            }
        }
        return Math.abs(arr[i] - arr[j]);
        */
    }
}
