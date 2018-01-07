package Leetcode.Review;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uslabs on 10/15/17.
 */
public class CanIWin {
    public static void solution() {
        System.out.println(canIWin(10, 40));
    }

    static Map<Integer, Boolean> map;
    static boolean[] used;

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        map = new HashMap();
        used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal);
    }

    public static boolean helper(int desiredTotal) {
        if (desiredTotal <= 0) return false;
        int key = format(used);
        if (!map.containsKey(key)) {
            // try every unchosen number as next step
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    // check whether this lead to a win (i.e. the other player lose)
                    if (!helper(desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    // transfer boolean[] to an Integer
    public static int format(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) num |= 1;
        }
        return num;
    }
}
