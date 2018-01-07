package Leetcode.Review;
import Leetcode.Utils.*;
/**
 * Created by uslabs on 10/23/17.
 */
public class CountCompleteTreeNodes {
    public static void solution() {
        TreeNode root = new TreeNode(1);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return countInternal(root) + countLeaf(root);
    }

    public static int level, leaves;

    public static int getLevel(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null)
            return 0;
        int l = 0;
        while (root != null) {
            root = root.left;
            l++;
        }
        return l - 1;
    }

    public static int countInternal(TreeNode root) {
        level = getLevel(root);
        leaves = (int) Math.pow(2, level);
        return leaves - 1;
    }

    public static int countLeaf(TreeNode root) {
        int leafCount = 0, count = leaves;
        for (int i = 1; i <= level; i++) {
            if (i == level) {
                if (root.right != null)
                    leafCount += count;
                else
                    leafCount += (root.left != null) ? count / 2 : 0;
            } else {
                if (getLevel(root.right) == level - i) {
                    leafCount += count / 2;
                    count /= 2;
                    root = root.right;
                } else {
                    root = root.left;
                    count /= 2;
                }
            }
        }
        return leafCount;
    }
}