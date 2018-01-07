package Leetcode;

import Leetcode.Utils.TreeNode;

/**
 * Created by uslabs on 6/12/17.
 */
public class FindBottomLeftTreeValue {
    public static void Solution() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        int[] arr = new int[2];
        arr[0] = root.val;
        arr[1] = 1;
        func(root, arr, 1);
        System.out.println(arr[0]);
    }

    // arr[0] = maxLevel
    // arr[1] = value

    public static void func(TreeNode root, int[] arr, int currLevel) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (currLevel > arr[1]) {
                arr[1] = currLevel;
                arr[0] = root.val;
            }
            return;
        }

        if (root.right == null) {
            func(root.left, arr, currLevel + 1);
            return;
        }

        if (root.left == null) {
            func(root.right, arr, currLevel + 1);
            return;
        }


        func(root.left, arr, currLevel + 1);
        func(root.right, arr, currLevel + 1);
        return;

    }
}