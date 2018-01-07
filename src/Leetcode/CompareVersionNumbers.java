package Leetcode;

/**
 * Created by uslabs on 10/8/17.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int min = Math.min(arr1.length, arr2.length), i = 0;
        for (; i < min; i++) {
            if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i]))
                return 1;
            if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i]))
                return -1;
        }

        if (i == arr1.length) {
            for (int j = min; j < arr2.length; j++) {
                if (Integer.parseInt(arr2[j]) != 0)
                    return -1;
            }
            return 0;
        } else {
            for (int j = min; j < arr1.length; j++) {
                if (Integer.parseInt(arr1[j]) != 0)
                    return 1;
            }
            return 0;
        }
    }
}