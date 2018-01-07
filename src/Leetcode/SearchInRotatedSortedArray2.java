package Leetcode;

import java.util.Arrays;

public class SearchInRotatedSortedArray2 {
    public static boolean search(int[] nums, int target) {
        int[] arr = {3, 4, 4, 5, 5, 6, 7, 7, 7, 8, 0, 1, 1, 2};
        if (nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;
        if (nums.length == 2) {
            if (nums[0] == target) return true;
            if (nums[1] == target) return true;
            return false;
        }

        if (nums[nums.length / 2] == target)
            return true;
        if (nums[0] == target)
            return true;
        if (nums[nums.length - 1] == target)
            return true;

        if (nums[0] < nums[nums.length / 2]) {
            if (target > nums[nums.length / 2] || target < nums[0])
                return search(Arrays.copyOfRange(nums, nums.length / 2, nums.length - 1), target);
            else
                return search(Arrays.copyOfRange(nums, 0, nums.length / 2 - 1), target);
        }

        if (nums[0] > nums[nums.length / 2]) {
            if (target > nums[nums.length / 2] && target < nums[nums.length - 1])
                return search(Arrays.copyOfRange(nums, nums.length / 2, nums.length - 1), target);
            else
                return search(Arrays.copyOfRange(nums, 0, nums.length / 2 - 1), target);
        }

        return false;
    }
}