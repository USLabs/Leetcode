package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by uslabs on 10/26/17.
 */
public class DegreeOfAnArray {
    public static void solution() {
        int[] nums = {1, 1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        int[] arr = new int[nums.length];
        ArrayList<Integer> cand = new ArrayList();
        arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int degree = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                degree = Math.max(degree, count);
                count = 1;
            }
        }
        degree = Math.max(degree, count);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (cand.contains(arr[i]))
                continue;
            int temp = getLength(arr, i, degree);
            if (temp != -1 && temp < result) {
                result = temp;
                cand.add(arr[i]);
            }
        }
        return result;
    }

    public static int getLength(int[] arr, int start, int degree) {
        int i = start;
        for (; i < arr.length && degree > 0; i++) {
            if (arr[i] == arr[start]) {
                degree--;
            }
        }
        if (degree == 0)
            return i - start;
        else return -1;
    }
}
