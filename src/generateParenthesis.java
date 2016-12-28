import java.util.LinkedList;
import java.util.List;

/**
 * Created by techmint on 12/6/16.
 */
public class generateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<String>();
        char[] arr = new char[2 * n];
        generateParenthesisUtil(list, arr, 0, n, 0, 0);
        return list;
    }

    public static void generateParenthesisUtil(List<String> list, char[] s, int pos, int n, int open, int close) {
        if (close == n) {
            list.add(String.valueOf(s));
            return;
        }
        if (open > close) {
            s[pos] = ')';
            generateParenthesisUtil(list, s, pos + 1, n, open, close + 1);
        }
        if (open < n) {
            s[pos] = '(';
            generateParenthesisUtil(list, s, pos + 1, n, open + 1, close);
        }
    }
}