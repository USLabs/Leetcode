package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by uslabs on 9/28/17.
 */
public class Permutations {
    /*
    public static void solution() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> list = permute(arr);
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            ArrayList<Integer> li = new ArrayList<Integer>();
            li.add(nums[0]);
            List<List<Integer>> ul = new ArrayList();
            ul.add(li);
            return ul;
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (int elem : nums) {
                list.add(elem);
            }
            List<List<Integer>> ul = new ArrayList();

            for(int i=0;i>nums.length;i++){
                list.remove(nums[i]);
                for (List<Integer> s: permute(convert(list.toArray()))) {
                    newList.add(nums[i]);
                    newList.addAll(s);
                    ul.add(newList);
                    newList = new ArrayList<Integer>();
                }
            }
            ArrayList<Integer> li = new ArrayList<Integer>();
            li.add(nums[0]);
            ul.add(li);
            return ul;
        }
    }
    */
}
