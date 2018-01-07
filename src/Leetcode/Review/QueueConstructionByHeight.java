package Leetcode.Review;

import java.util.*;

/**
 * Created by uslabs on 10/24/17.
 */
public class QueueConstructionByHeight {
    public static void solution() {
        int[][] people = {
                {7, 0},
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        int[][] arr = reconstructQueue(people);
        for (int i = 0; i < arr.length; i++) {
            for (int ii = 0; ii < arr[0].length; ii++) {
                System.out.print(arr[i][ii] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
}