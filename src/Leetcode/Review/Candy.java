package Leetcode.Review;

import java.util.Arrays;

/**
 * Created by uslabs on 11/24/17.
 */
public class Candy {
    public static void solution() {
        int[] arr = {5, 4, 3, 2, 6, 10, 8, 7};
        System.out.println(candy(arr));

    }

    public static int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < candies.length; i++){
            if (ratings[i] > ratings[i - 1]) candies[i] = (candies[i - 1] + 1);
        }

        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
        }

        int sum = 0;
        for (int candy : candies)
            sum += candy;
        return sum;
    }
}