package Leetcode;

import java.util.Arrays;

/**
 * Created by uslabs on 12/5/17.
 */
public class TwitterFixedDistance {
    public static void solution() {
        int[] arr = {1, 5, 3, 4, 2};
        int d = 2;
        System.out.println(fixedDistance(arr, d));
    }

    static int fixedDistance(int[] a, int d) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] - a[i] == d) {
                    count++;
                }

                if (a[j] - a[i] > d)
                    break;
            }
        }
        return count;
    }
}
