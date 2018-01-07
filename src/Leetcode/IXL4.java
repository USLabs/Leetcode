package Leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by uslabs on 12/13/17.
 */
public class IXL4 {
    public static void solution() {
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println(degreeOfArr(arr));
    }

    public static int degreeOfArr(int[] nums) {
        HashMap<Integer, Integer> map1 = new HashMap();
        HashMap<Integer, Integer> map2 = new HashMap();
        HashMap<Integer, Integer> temp = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map1.get(x) == null) map1.put(x, i);
            map2.put(x, i);
            temp.put(x, temp.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(temp.values());
        for (int x : temp.keySet()) {
            if (temp.get(x) == degree) {
                ans = Math.min(ans, map2.get(x) - map1.get(x) + 1);
            }
        }
        return ans;
    }
}
