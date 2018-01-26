package Coursera;

import java.util.HashMap;

/**
 * Created by uslabs on 1/3/18.
 */
public class courseraMin {
    public static void solution() {
        int[] arr = {1, 2, 2};
        System.out.println(getMinimumUniqueSum(arr));
    }

    static int getMinimumUniqueSum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) > 1) {
                int temp = arr[i];
                while (map.containsKey(temp))
                    temp++;
                sum += temp;
                map.put(temp, 1);
                if (map.get(arr[i]).intValue() - 1 == 0)
                    map.remove(arr[i]);
                else
                    map.put(arr[i], map.get(arr[i]) - 1);
            } else
                sum += arr[i];
        }
        return sum;
    }
}
