package Leetcode;

import java.util.Stack;

/**
 * Created by uslabs on 10/23/17.
 */
public class EvaluateReversePolishNotation {
    public static void solution() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] arr) {
        Stack<Integer> stack = new Stack();
        int a, b;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(arr[i]));
            }
        }
        return stack.pop();
    }
}
