package Leetcode;

/**
 * Created by techmint on 10/31/16.
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int maxTillNow = 0, maxTillHere = 0, minTillHere = 0, a, b;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                if (nums[i] > 0) {
                    maxTillHere = nums[i];
                    maxTillNow = nums[i];
                } else {
                    minTillHere = nums[i];
                    maxTillNow = nums[i];
                }
            } else {
                if (nums[i] > 0) {
                    a = nums[i] * (maxTillHere == 0 ? 1 : maxTillHere);
                    b = nums[i] * minTillHere;
                    maxTillHere = a;
                    minTillHere = b;
                    maxTillNow = Math.max(maxTillNow, maxTillHere);
                } else {
                    a = nums[i] * minTillHere;
                    b = nums[i] * (maxTillHere == 0 ? 1 : maxTillHere);
                    maxTillHere = a;
                    minTillHere = b;
                    maxTillNow = Math.max(maxTillNow, maxTillHere);
                }
            }
        }
        return maxTillNow;
    }
}
