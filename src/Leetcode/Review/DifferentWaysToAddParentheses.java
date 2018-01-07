package Leetcode.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uslabs on 10/24/17.
 */
public class DifferentWaysToAddParentheses {
    public static void solution() {
        List<Integer> list = diffWaysToCompute("2*3-4*5");
        System.out.println(list);
    }

    public static List<Integer> diffWaysToCompute(String str) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                String left = str.substring(0, i);
                String right = str.substring(i + 1);
                List<Integer> l1 = diffWaysToCompute(left);
                List<Integer> l2 = diffWaysToCompute(right);
                for (Integer p1 :   l1) {
                    for (Integer p2 : l2) {
                        int c = 0;
                        switch (str.charAt(i)) {
                            case '+':
                                c = p1 + p2;
                                break;
                            case '-':
                                c = p1 - p2;
                                break;
                            case '*':
                                c = p1 * p2;
                                break;
                        }
                        list.add(c);
                    }
                }
            }
        }
        if(list.size()==0)
            list.add(Integer.valueOf(str));
        return list;
    }
}
