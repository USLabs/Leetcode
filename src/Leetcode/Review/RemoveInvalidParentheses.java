package Leetcode.Review;

import java.util.*;

/**
 * Created by uslabs on 10/31/17.
 */
public class RemoveInvalidParentheses {
    public static void solution() {
        //"()())()" -> ["()()()", "(())()"]
        //"(a)())()" -> ["(a)()()", "(a())()"]
        //")(" -> [""]
        for (String s : removeInvalidParentheses("()())()")) {
            System.out.println(s);
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList();
        if (s == null) {
            return result;
        }
        HashSet<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.add(s);
        boolean found = false;
        //two ways, check first then push child
        //or check child...
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (checkValid(cur)) {
                result.add(cur);
                found = true;
            }
            if (found) {
                continue;
            }
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') {
                    continue;
                }
                String t = cur.substring(0, i) + cur.substring(i + 1);
                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return result;
    }

    private static boolean checkValid(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int mark = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                mark++;
            } else if (str.charAt(i) == ')') {
                mark--;
                if (mark < 0) {
                    return false;
                }
            }
        }
        return mark == 0;
    }
}