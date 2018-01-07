package Leetcode;

import Leetcode.Utils.TreeNode;

/**
 * Created by uslabs on 10/12/17.
 */
public class ValidateBinarySearchTree {
    public static void solution() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(-2147483648);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE, true, true);
    }

    public static boolean isBSTUtil(TreeNode node, int min, int max, boolean allowMin, boolean allowMax) {

        /* an empty tree is BST */
        if (node == null)
            return true;
        if (node.val == Integer.MAX_VALUE) {
            if (allowMax) {
                return (isBSTUtil(node.left, min, node.val - 1, allowMin, false) && node.right == null);
            } else
                return false;
        }


        if (node.val == Integer.MIN_VALUE) {
            if (allowMin) {
                return (node.left == null && isBSTUtil(node.right, node.val + 1, max, false, allowMax));
            } else
                return false;
        }

        /* false if this node violates the min/max constraints */
        if (node.val < min || node.val > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.val - 1, allowMin, false) &&
                isBSTUtil(node.right, node.val + 1, max, false, allowMax));
    }
}