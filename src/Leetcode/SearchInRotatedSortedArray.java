package Leetcode;

import java.util.Arrays;

/**
 * Created by techmint on 10/14/16.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return -1;

        if (n == 1)
            return (nums[0] == target) ? 0 : -1;

        if (n == 2)
            return (nums[0] == target) ? 0 : ((nums[1] == target) ? 1 : -1);

        if (nums[n / 2] == target)
            return n / 2;


        if (nums[n / 2] > nums[0]) {
            if (target >= nums[0] && target <= nums[n / 2]) {
                // left
                return search(Arrays.copyOfRange(nums, 0, n / 2), target);
            } else {
                // right
                int a = search(Arrays.copyOfRange(nums, n / 2, n), target);
                return (a == -1) ? -1 : (n / 2 + a);
            }
        }

        if (nums[n / 2] < nums[n - 1]) {
            if (target >= nums[n / 2] && target <= nums[n - 1]) {
                // right
                int a = search(Arrays.copyOfRange(nums, n / 2, n), target);
                return (a == -1) ? -1 : (n / 2 + a);
            } else {
                // left
                return search(Arrays.copyOfRange(nums, 0, n / 2), target);
            }
        }
        return -1;
    }
}

class SearchInRotatedSortedArrayDriver {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(SearchInRotatedSortedArray.search(arr, 0));
    }
}
