package Leetcode;

import java.util.ArrayList;

/**
 * Created by uslabs on 11/25/17.
 */
public class AsteroidCollision {

    public static void solution() {
        int[] arr = {5, 10, -5};
        System.out.println(asteroidCollision(arr).toString());


    }

    public static int[] asteroidCollision(int[] arr) {
        int lcol = -1, rcol = -1;
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                lcol = i;
                list.add(arr[i]);
            } else {
                int k = list.size() - 1;
                if (k >= 0 && list.get(k) > 0 && Math.abs(list.get(k)) < Math.abs(arr[i])) {
                    list.remove(k);
                    i--;
                    continue;
                }
                if (k < 0)
                    list.add(arr[i]);
                else {
                    if (list.get(k) < 0) {
                        list.add(arr[i]);
                    } else {
                        if (Math.abs(list.get(k)) == Math.abs(arr[i])) {
                            list.remove(k);
                        }
                    }
                }
            }
        }
        int[] arr2 = new int[list.size()];
        int i = 0;
        for (Integer a : list) {
            arr2[i++] = a;
        }
        return arr2;
    }
}
