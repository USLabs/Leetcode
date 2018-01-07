package Leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * Created by uslabs on 10/14/17.
 */
public class DecodeWays {
    public static void solution() {
        System.out.println(numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
        String s = "alpha123";
    }

    public static int numDecodings(String s) {
        int[] arr = new int[s.length()];
        Arrays.fill(arr, -1);
        return numCodingUtil(s, arr, 0);
    }

    public static int numCodingUtil(String s, int[] arr, int x) {
        if (s.length() == 0)
            return 0;

        if (s.charAt(x) == '0')
            return 0;

        if (s.length() - x == 1)
            return 1;

        if (arr[x] != -1)
            return arr[x];

        if (Integer.parseInt(s.substring(x, x + 2)) <= 26) {
            if (s.length() - x == 2) {
                arr[x] = 1 + ((s.charAt(x) != '0') ? numCodingUtil(s, arr, x + 1) : 0);
            } else {
                int a;
                if (s.charAt(x) == '0')
                    a = 0;
                else
                    a = numCodingUtil(s, arr, x + 1);
                int b = numCodingUtil(s, arr, x + 2);
                arr[x] = a + b;
            }
        } else {
            if (s.charAt(x) != '0') {
                arr[x] = numCodingUtil(s, arr, x + 1);
            } else
                arr[x] = 0;
        }
        return arr[x];
    }
}