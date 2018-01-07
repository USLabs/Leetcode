package Leetcode;

import java.util.List;

/**
 * Created by uslabs on 10/2/17.
 */
public class WordLadder {
    public static int[][] graph;

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int beginIndex = wordList.size(), endIndex = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord))
                endIndex = i;
            if (wordList.get(i).equals(beginWord))
                beginIndex = i;
        }

        if (endIndex != -1) {

            if (beginIndex == wordList.size()) {
                // Create Graph
                graph = new int[wordList.size() + 1][wordList.size() + 1];

                for (int i = 0; i < wordList.size(); i++) {
                    if (distance(beginWord, wordList.get(i)) == 1) {
                        graph[i][wordList.size()] = 1;
                        graph[wordList.size()][i] = 1;
                    }
                }

            } else {
                // Create Graph
                graph = new int[wordList.size()][wordList.size()];

            }

            for (int ii = 0; ii < wordList.size(); ii++) {
                for (int i = 0; i < wordList.size(); i++) {
                    if (i == ii)
                        continue;
                    if (graph[ii][i] != 0)
                        continue;
                    if (distance(wordList.get(ii), wordList.get(i)) == 1) {
                        graph[ii][i] = 1;
                        graph[i][ii] = 1;
                    }
                }
            }

            int min = getMinDistance(beginIndex, endIndex, graph);
            if (min == Integer.MAX_VALUE)
                return 0;

            return 1 + min;
        } else
            return 0;
    }


    public static int getMinDistance(int beginIndex, int endIndex, int[][] graph) {
        if (beginIndex == endIndex)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < graph[beginIndex].length; i++) {
            if (graph[beginIndex][i] == 1) {
                graph[beginIndex][i] = 2;
                graph[i][beginIndex] = 2;
                int k = getMinDistance(i, endIndex, graph);
                min = (k != Integer.MAX_VALUE) ? Math.min(min, 1 + k) : min;
                graph[beginIndex][i] = 1;
                graph[beginIndex][i] = 1;
            }
        }
        return min;
    }

    public static int distance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i))
                continue;
            else
                dist++;
        }
        return dist;
    }
}