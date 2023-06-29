public class Solution {
    static int max;

    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        max = 0;
        f(root);
        if (max > 1)
            return false;
        return true;
    }

    static int f(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 1;
        int left = f(root.left);
        int right = f(root.right);
        max = Math.max(max, Math.abs(left - right));
        return 1 + Math.max(left, right);
    }
}
// Time complexity : O(n)