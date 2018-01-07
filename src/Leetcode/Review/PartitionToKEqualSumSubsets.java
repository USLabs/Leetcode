package Leetcode.Review;

/**
 * Created by uslabs on 10/26/17.
 */
public class PartitionToKEqualSumSubsets {
    public static void solution() {
        int[] nums = {15, 13, 2, 7, 8};
        int k = 3;
        System.out.println(canPartitionKSubsets(nums, k));

    }

    public static boolean canPartitionKSubsets(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int[] visited = new int[arr.length];
        if (k < 0 || sum % k != 0)
            return false;
        return canPartitionKSubsetsUtil(arr, visited, k, sum / k, 0, 0, 0);
    }

    public static boolean canPartitionKSubsetsUtil(int[] arr, int[] visited, int k, int sum, int curr_sum, int cur_num, int startIndex) {
        if (k == 1)
            return true;
        if (curr_sum == sum && cur_num > 0)
            return canPartitionKSubsetsUtil(arr, visited, k - 1, sum, 0, 0, 0);

        for (int i = startIndex; i < arr.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (canPartitionKSubsetsUtil(arr, visited, k, sum, curr_sum + arr[i], ++cur_num, i + 1)) return true;
                visited[i] = 0;
            }
        }
        return false;
    }
}
