package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by uslabs on 12/4/17.
 */
public class TwitterGeneticMutation {
    public static int findMutationDistance(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        char[] setAllowed = new char[]{'A', 'C', 'G', 'T'};
        Set<String> setForBank = new HashSet<>();
        for (String b : bank) setForBank.add(b);

        int k = 0;
        Set<String> viewed = new HashSet<>();
        Queue<String> myQueue = new LinkedList<>();
        myQueue.offer(start);
        viewed.add(start);

        while (!myQueue.isEmpty()) {
            int sizeOfQueue = myQueue.size();
            while (sizeOfQueue-- > 0) {
                String curr = myQueue.poll();
                if (curr.equals(end)) return k;

                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char newChar = arr[i];
                    for (char ch : setAllowed) {
                        arr[i] = ch;
                        String nextString = new String(arr);
                        if (!viewed.contains(nextString) && setForBank.contains(nextString)) {
                            viewed.add(nextString);
                            myQueue.offer(nextString);
                        }
                    }
                    arr[i] = newChar;
                }
            }
            k++;
        }
        return -1;
    }
}
