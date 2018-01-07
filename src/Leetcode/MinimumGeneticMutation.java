package Leetcode;

import java.util.LinkedList;

/**
 * Created by uslabs on 10/27/17.
 */
public class MinimumGeneticMutation {
    public static void solution() {
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", bank));
    }

    public static void solution2() {
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation2("AACCGGTT", "AACCGGTA", bank));
    }

    public static int minMutation(String start, String end, String[] bank) {
        int[] visited = new int[bank.length];
        return dfsutil(start, end, bank, visited);
    }

    public static int dfsutil(String start, String end, String[] bank, int[] visited) {
        if (start == end)
            return 0;
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < bank.length; i++) {
            if (visited[i] == 0) {
                int c = getCount(start, bank[i]);
                if (c == 1) {
                    visited[i] = 1;
                    int t = dfsutil(bank[i], end, bank, visited);
                    visited[i] = 0;
                    if (t == -1) {
                        continue;
                    } else {
                        m = Math.min(m, 1 + t);
                    }

                }
            }
        }

        if (m == Integer.MAX_VALUE)
            return -1;
        return m;
    }

    public static int getCount(String a, String b) {
        if (a.length() != b.length())
            return -1;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return count;
    }

    public static int minMutation2(String start, String end, String[] bank) {
        int[] visited = new int[bank.length];
        return bfsutil(start, end, bank, visited);
    }

    public static int bfsutil(String start, String end, String[] bank, int[] visited) {

        if (start == end)
            return 0;

        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < bank.length; i++) {
            if (visited[i] == 0) {
                int c = getCount(start, bank[i]);
                if (c == 0)
                    return 0;
                if (c == 1) {
                    visited[i] = 1;
                    list.addLast(bank[i]);
                }
            }
        }

        int m = Integer.MAX_VALUE;
        while (!list.isEmpty()) {
            int b = 1 + bfsutil(list.poll(), end, bank, visited);
            if (b != -1)
                m = Math.min(m, b);
        }
        if (m == Integer.MAX_VALUE)
            return -1;
        return m;
    }
}
