package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by uslabs on 11/1/17.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void solution() {
        String digits = "23";
        for (String s : letterCombinations(digits)) {
            System.out.println(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        String[] arr = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            arr[i] = map.get(Integer.valueOf(digits.charAt(i)));
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

        }
        return result;
    }
}
