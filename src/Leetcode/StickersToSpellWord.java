package Leetcode;

import java.util.HashMap;

/**
 * Created by uslabs on 11/5/17.
 */
public class StickersToSpellWord {
    public static void solution() {
        String[] arr = {"crowd", "level", "after", "equate", "at", "spend", "out"};
        String s = "catread";
        System.out.println(minStickers(arr, s));
    }

    private static HashMap<String, Integer> map = new HashMap<>();

    public static int minStickers(String[] stickers, String target) {
        if (target == null || target.length() == 0)
            return 0;
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stickers.length; i++) {
            String newTarget = containsThenTake(target, stickers[i]);
            if (newTarget == null) {
                continue;
            } else {
                int temp = minStickers(stickers, newTarget);
                if (temp == -1) {
                    map.put(target, -1);
                    return -1;
                } else
                    min = Math.min(min, 1 + temp);
            }
        }
        if (min == Integer.MAX_VALUE)
            min = -1;
        map.put(target, min);
        return min;
    }

    private static String containsThenTake(String a, String b) {
        StringBuilder aa = new StringBuilder(a);
        StringBuilder bb = new StringBuilder(b);
        for (int i = 0; i < aa.length(); ) {
            int index = bb.indexOf(aa.substring(i, i + 1));
            if (index != -1) {
                bb.deleteCharAt(index);
                aa.deleteCharAt(i);
            } else {
                i++;
            }
        }
        if (aa.length() == 0)
            return "";

        if (aa.length() == a.length())
            return null;

        return aa.toString();
    }
}
