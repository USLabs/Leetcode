package Leetcode;

/**
 * Created by uslabs on 11/2/17.
 */
public class HammingDistance {
    public static void solution() {
        System.out.println(hammingDistance(3, 1));
    }

    public static int hammingDistance(int x, int y) {
        StringBuilder a = new StringBuilder(Integer.toBinaryString(x));
        StringBuilder b = new StringBuilder(Integer.toBinaryString(y));
        while (a.length() < b.length()) {
            a.insert(0, '0');
        }

        while (b.length() < a.length()) {
            b.insert(0, '0');
        }

        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return count;
    }
}
