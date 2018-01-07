package Leetcode;

import java.util.Stack;

/**
 * Created by uslabs on 11/2/17.
 */
public class RomanToInteger {

    public static void solution() {
        System.out.println(romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        int[] romans = new int[26];

        romans['M' - 65] = 1000;
        romans['D' - 65] = 500;
        romans['C' - 65] = 100;
        romans['L' - 65] = 50;
        romans['X' - 65] = 10;
        romans['V' - 65] = 5;
        romans['I' - 65] = 1;

        Stack<Character> stack = new Stack<>();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int prev = 0;
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (prev == 0) {
                num += romans[ch - 65];
                prev = num;
            } else {
                if (romans[ch - 65] < prev)
                    num -= romans[ch - 65];
                else
                    num += romans[ch - 65];
                prev = romans[ch - 65];
            }
        }
        return num;
    }
}