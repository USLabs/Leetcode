package Leetcode;

/**
 * Created by uslabs on 10/28/17.
 */
public class OneBitTwoBit {
    public static void solution() {
        int[] arr = {1, 1, 1, 0};
        System.out.println(isOneBitCharacter(arr));

    }

    public static boolean isOneBitCharacter(int[] arr) {
        return util(arr, 0);
    }

    public static boolean util(int[] arr, int i) {
        if (i >= arr.length)
            return false;

        if (arr[i] == 1) {
            if (i + 2 >= arr.length)
                return false;
            return util(arr, i + 2);
        } else {
            if (i + 1 >= arr.length)
                return true;
            return util(arr, i + 1);
        }

    }
}
