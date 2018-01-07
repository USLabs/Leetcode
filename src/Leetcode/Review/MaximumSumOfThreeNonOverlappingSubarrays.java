package Leetcode.Review;

/**
 * Created by uslabs on 10/6/17.
 */
public class MaximumSumOfThreeNonOverlappingSubarrays {
    public static int[][][] sum;
    public static int last;

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int max = 0;
        last = nums.length - k + 1;
        sum = new int[last + 1][last + 1][last + 1];
        int[] result = {-1, -1, -1};
        for (int a = 0; a <= nums.length - k - k - k; a++) {
            fillSingleSum(a, nums, k);
            for (int b = a + k; b <= nums.length - k - k; b++) {
                fillDoubleSum(a, b, nums, k);
                for (int c = b + k; c <= nums.length - k; c++) {
                    fillTripleSum(a, b, c, nums, k);
                    if (sum[a][b][c] > max) {
                        result[0] = a;
                        result[1] = b;
                        result[2] = c;
                        max = sum[a][b][c];
                    }
                }
            }
        }
        return result;
    }

    public static void fillSingleSum(int a, int[] arr, int k) {
        if (a != 0 && sum[a - 1][last][last] != 0) {
            sum[a][last][last] = sum[a - 1][last][last] - arr[a - 1] + arr[a + k - 1];
        }
        if (sum[a][last][last] == 0) {
            for (int aa = a; aa < a + k; aa++)
                sum[a][last][last] += arr[aa];
        }
    }

    public static void fillDoubleSum(int a, int b, int[] arr, int k) {
        if (b != 0 && sum[a][b - 1][last] != 0) {
            sum[a][b][last] = sum[a][b - 1][last] - arr[b - 1] + arr[b + k - 1];
        }

        if (sum[a][b][last] == 0) {
            fillSingleSum(a, arr, k);
            fillSingleSum(b, arr, k);
            sum[a][b][last] += sum[a][last][last] + sum[b][last][last];
        }
    }

    public static void fillTripleSum(int a, int b, int c, int[] arr, int k) {
        if (c != 0 && sum[a][b][c - 1] != 0) {
            sum[a][b][c] = sum[a][b][c - 1] - arr[c - 1] + arr[c + k - 1];
        }

        if (sum[a][b][c] == 0) {
            fillDoubleSum(a, b, arr, k);
            fillDoubleSum(b, c, arr, k);
            fillDoubleSum(c, a, arr, k);
            sum[a][b][c] = (sum[a][b][last] + sum[b][c][last] + sum[c][a][last]) / 2;
        }
    }

    public static int[] maxSumOfThreeSubarrays2(int[] nums, int k) {
        int[] result = {-1, -1, -1};
        int[][] lMax = new int[nums.length][2], rMax = new int[nums.length][2], max = new int[nums.length][2], cMax = new int[nums.length][2];
        int l = 0, r = 0, currMax = 0;
        for (int i = nums.length - k - k; i >= k; i--) {
            if (rMax[i + 1][0] != 0) {
                int temp = 0;
                for (int j = i + k; j < i + k + k; j++) {
                    temp += nums[j];
                }
                if (temp > rMax[i + 1][0]) {
                    rMax[i][0] = temp;
                    r = i + k;
                } else
                    rMax[i] = rMax[i + 1];
            } else {
                int temp = 0;
                for (int j = nums.length - k; j < nums.length; j++) {
                    temp += nums[j];
                }

                rMax[i][0] = temp;
                r = i + k;
            }
            rMax[i][1] = r;
        }

        for (int i = k; i <= nums.length - k - k; i++) {
            if (lMax[i - 1][0] != 0) {
                int temp = 0;
                for (int j = i - k; j < i; j++) {
                    temp += nums[j];
                }
                if (temp > lMax[i - 1][0]) {
                    lMax[i][0] = temp;
                    l = i - k;
                } else
                    lMax[i] = lMax[i - 1];
            } else {
                int temp = 0;
                for (int j = i - k; j < i; j++) {
                    temp += nums[j];
                }
                lMax[i][0] = temp;
                l = i - k;
            }
            lMax[i][1] = l;

            if (cMax[i - 1][0] != 0) {
                cMax[i][0] = cMax[i - 1][0] - nums[i - 1] + nums[i + k - 1];
            } else {
                int temp = 0;
                for (int j = i; j < i + k; j++) {
                    temp += nums[j];
                }
                cMax[i][0] = temp;
            }
            cMax[i][1] = i;

            max[i][0] = lMax[i][0] + cMax[i][0] + rMax[i][0];
            if (max[i][0] > currMax) {
                currMax = max[i][0];
                result[0] = lMax[i][1];
                result[1] = cMax[i][1];
                result[2] = rMax[i][1];
            }
        }
        return result;
    }
}