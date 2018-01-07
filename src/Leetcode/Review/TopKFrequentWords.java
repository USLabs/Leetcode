package Leetcode.Review;

import java.util.*;

/**
 * Created by uslabs on 10/20/17.
 */
public class TopKFrequentWords {

    public static void solution() {
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(arr, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.count - o2.count;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> result = new ArrayList<String>();
        while (queue.size() > 0) {
            result.add(queue.poll().word);
        }
        //reverse the order
        Collections.reverse(result);
        return result;
    }
}

class Pair {
    String word;
    int count;

    public Pair(String thisWord, int count) {
        this.word = thisWord;
        this.count = count;
    }
}