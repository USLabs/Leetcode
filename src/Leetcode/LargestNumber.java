package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by uslabs on 10/13/17.
 */
public class LargestNumber {
    public static void solution() {
        int[] nums = {121, 12};
        System.out.println(largestNumber(nums));
        System.out.println("Expected Output : ");
        System.out.println("12121");

        System.out.println("---------------------------");

        int[] nums2 = {824, 1399, 5607, 6973, 5703, 4398, 8247};
        System.out.println(largestNumber(nums2));
        System.out.println("Expected Output : ");
        System.out.println("824824769735703560743981399");
    }

    public static String largestNumber(int[] arr) {

        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String aa = Integer.toString(a) + Integer.toString(b);
                String bb = Integer.toString(b) + Integer.toString(a);
                int i = 0;
                for (; i < aa.length(); i++) {
                    if (aa.charAt(i) > bb.charAt(i))
                        return 1;
                    if (aa.charAt(i) < bb.charAt(i))
                        return -1;
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(Integer.toString(nums[i]));
        }
        boolean flag = false;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0')
                break;
            if (sb.charAt(i) == '0' && flag) {
                sb.deleteCharAt(i);
                i--;
                continue;
            }

            if (sb.charAt(i) == '0' && !flag) {
                flag = true;
                continue;
            }
        }
        return sb.toString();
    }
}