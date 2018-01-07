package Leetcode;

import java.util.Stack;

/**
 * Created by uslabs on 11/2/17.
 */
public class ValidParentheses {
    public static void solution() {
        String s = "]";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                switch (c) {
                    case ')': {
                        if (stack.pop() != '(')
                            return false;
                        break;
                    }
                    case '}': {
                        if (stack.pop() != '{')
                            return false;
                        break;
                    }
                    case ']': {
                        if (stack.pop() != '[')
                            return false;
                        break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
