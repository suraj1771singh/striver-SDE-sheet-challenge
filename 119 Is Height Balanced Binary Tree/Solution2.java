public class Solution {
    static int max;

    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        int h = f(root);
        if (h == -1)
            return false;
        return true;
    }

    static int f(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 1;
        int left = f(root.left);
        if (left == -1)
            return -1;
        int right = f(root.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right);
    }
}

//Time complexity : O(n), but did little bit of prunning, 