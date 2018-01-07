package Leetcode;

import java.util.*;

/**
 * Created by uslabs on 10/11/17.
 */
public class MaximumAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, maxArea(grid, i, j));
            }
        }

        return max;
    }

    public static int maxArea(int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + maxArea(grid, i + 1, j) + maxArea(grid, i - 1, j) + maxArea(grid, i, j - 1) + maxArea(grid, i, j + 1);
        }
        return 0;
    }
}