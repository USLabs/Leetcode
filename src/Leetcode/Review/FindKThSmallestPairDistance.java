package Leetcode.Review;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by uslabs on 11/19/17.
 */
public class FindKThSmallestPairDistance {
    public static void solution() {
        int[] arr = {4, 10, 3, 3, 10, 6, 1, 6, 2, 10, 5, 9, 0, 6, 7, 5, 0, 1, 5, 1, 1, 0, 7, 8, 2, 10, 0, 3, 7, 1, 10, 10, 0, 1, 6, 5, 9, 1, 1, 10, 1, 10, 6, 4, 9, 6, 10, 0, 8, 8, 9, 1, 7, 4, 7, 0, 9, 0, 6, 10, 2, 4, 3, 8, 10, 6, 5, 1, 7, 10, 1, 4, 4, 2, 7, 3, 1, 3, 8, 2, 6, 3, 8, 3, 0, 3, 5, 5, 8, 9, 3, 5, 2, 5, 6, 6, 8, 3, 2, 0, 2, 7, 7, 1, 0, 4, 9, 8, 6, 5, 6, 1, 8, 4, 7, 7, 0, 1, 10, 0, 7, 7, 7, 2, 3, 10, 4, 9, 1, 0, 3, 8, 10, 7, 4, 3, 7, 6, 2, 5, 9, 4, 10, 1, 3, 8, 9, 3, 3, 2, 10, 2, 6, 6, 0, 3, 4, 2, 1, 8, 7, 2, 10, 6, 6, 8, 5, 4, 1, 3, 10, 1, 7, 3, 4, 10, 0, 3, 6, 0, 2, 4, 0, 10, 10, 4, 1, 3, 7, 4, 2, 3, 1, 0, 1, 2, 2, 9, 0, 3};
        int k = 10000;
        System.out.println(smallestDistancePair(arr, k));
    }

    // Returns index of first index of element which is greater than key
    private static int upperBound(int[] a, int low, int high, int key) {
        if (a[high] <= key) return high + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key >= a[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Returns number of pairs with absolute difference less than or equal to mid.
    private static int countPairs(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; i++) {
            res += upperBound(a, i, n - 1, a[i] + mid) - i - 1;
        }
        return res;
    }

    public static int smallestDistancePair(int a[], int k) {
        int n = a.length;
        Arrays.sort(a);

        // Minimum absolute difference
        int low = a[1] - a[0];
        for (int i = 1; i < n - 1; i++)
            low = Math.min(low, a[i + 1] - a[i]);

        // Maximum absolute difference
        int high = a[n - 1] - a[0];

        // Do binary search for k-th absolute difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(a, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

}
