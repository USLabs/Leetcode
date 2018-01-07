package Leetcode;

/**
 * Created by uslabs on 10/28/17.
 */
public class StringCompression {
    public static void solution() {
        char[] arr = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(arr));
    }

    public static int compress(char[] chars) {
        if (chars.length <= 1)
            return chars.length;

        char prev = chars[0];
        int prevCount = 1;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                prevCount++;
            } else {
                if (prevCount != 1) {
                    chars[j++] = prev;
                    prev = chars[i];
                    String s = Integer.toString(prevCount);
                    for (int a = 0; a < s.length(); a++) {
                        chars[j] = s.charAt(a);
                        j++;
                    }
                    prevCount = 1;
                } else {
                    chars[j++] = prev;
                    prev = chars[i];
                    prevCount = 1;
                }
            }

            if (i == chars.length - 1) {
                chars[j++] = prev;
                if (prevCount != 1) {
                    String s = Integer.toString(prevCount);
                    for (int a = 0; a < s.length(); a++) {
                        chars[j] = s.charAt(a);
                        j++;
                    }
                }
            }
        }
        return j;
    }
}
