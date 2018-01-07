package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by uslabs on 10/13/17.
 */
public class ThreeSum {
    public static void solution() {
        int[] nums = {1,-1,-1,0};
        //int[] nums = {-1, 0, 0, 0, 1, 2, -1, -4};
        List<List<Integer>> answer = threeSum(nums);
        for (List<Integer> l : answer) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            findSum(nums, result, i);
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;
        }
        return result;
    }

    public static void findSum(int[] arr, List<List<Integer>> result, int first) {
        for (int i = first + 1, j = arr.length - 1; i < j; ) {
            if (i == first) {
                i++;
                continue;
            }
            if (j == first) {
                j--;
                continue;
            }
            if (arr[i] + arr[j] == -arr[first]) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[first]);
                list.add(arr[i]);
                list.add(arr[j]);
                result.add(list);
                while (i + 1 < arr.length && arr[i + 1] == arr[i])
                    i++;
                while (j - 1 >= 0 && arr[j - 1] == arr[j])
                    j--;
                i++;
                j--;
            } else {
                if (arr[i] + arr[j] > -arr[first]) {
                    j--;
                } else {
                    i++;
                }
            }
        }
    }
}