package Leetcode;

import java.util.Arrays;

/**
 * Created by uslabs on 10/8/17.
 */
public class CircularArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        int[] isVisited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int next = i, flag = 0;
            while (next >= 0 && next < nums.length && isVisited[next] == 0) {
                isVisited[next] = 1;
                next = next + nums[next];
                if (next >= nums.length)
                    next = next - nums.length;
                else {
                    if (next < 0) {
                        next = next + nums.length;
                    }
                }
            }

            if (next >= 0 && next < nums.length && countElem(nums, next)) {
                return true;
            } else {
                Arrays.fill(isVisited, 0);
                continue;
            }
        }
        return false;
    }

    public static boolean countElem(int[] nums, int index) {
        int next = -1, count = 0, flag = 0;
        boolean change = false;
        while (next != index) {
            count++;
            if (next == -1) {
                next = index + nums[index];
                flag = (nums[index] > 0) ? 1 : -1;
            } else {
                if ((nums[next] > 0 && flag == 1) || (nums[next] < 0 && flag == -1))
                    change = false;
                else
                    return false;
                next = next + nums[next];
            }
            if (next >= nums.length)
                next -= nums.length;
            if (next < 0)
                next += nums.length;
        }
        if (count > 1 && !change)
            return true;
        else
            return false;
    }

    public static boolean circularArrayLoop2(int[] nums) {
        int flag = 0, next, elems;
        boolean change = false;
        for (int i = 0; i < nums.length; i++) {
            next = i;
            elems = 0;
            while (next >= 0 && next < nums.length && nums[next] != 0) {
                if (nums[next] > 0) {
                    if (flag == -1)
                        change = true;
                    else
                        flag = 1;
                } else {
                    if (flag == 1)
                        change = true;
                    else
                        flag = -1;
                }
                int temp = nums[next];
                if (change)
                    break;
                nums[next] = 0;
                elems++;
                next = next + temp;
                if (next >= nums.length)
                    next = next - nums.length;
                else {
                    if (next < 0) {
                        next = next + nums.length;
                    }
                }
            }

            if (!change && elems > 1)
                return true;
        }
        return false;
    }

    public static boolean countElem2(int[] nums, int index) {
        int next = -1, count = 0;
        while (next != index) {
            count++;
            if (next == -1) {
                next = index + nums[index];
            } else {
                next = next + nums[next];
            }
            if (next >= nums.length)
                next -= nums.length;
            if (next < 0)
                next += nums.length;
        }
        if (count > 1)
            return true;
        else
            return false;
    }
}
