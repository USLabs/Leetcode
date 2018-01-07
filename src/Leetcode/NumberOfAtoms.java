package Leetcode;

import java.util.*;

/**
 * Created by uslabs on 11/13/17.
 */
public class NumberOfAtoms {
    public static void solution() {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }

    private static HashMap<String, Integer> map;

    public static String countOfAtoms(String formula) {
        map = new HashMap();
        StringBuilder sb = new StringBuilder();
        countHelper(formula);
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String str : list) {
            int val = map.get(str);
            if (val == 1)
                sb.append(str);
            else
                sb.append(str + val);
        }
        return sb.toString();
    }

    private static void countHelper(String formula) {
        int i = 0;
        while (i < formula.length()) {
            int count = 0, j = i;
            for (; j < formula.length(); j++) {
                if (formula.charAt(j) == '(') count++;
                else if (formula.charAt(j) == ')') count--;
                if (count == 0) break;
            }
            countHelper(formula.substring(i + 1, j));

        }
    }
}