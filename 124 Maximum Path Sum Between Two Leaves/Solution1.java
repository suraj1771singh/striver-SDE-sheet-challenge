public class Solution {
    static long ans;

    public static long findMaxSumPath(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return -1;
        ans = -1;
        f(root);
        return ans;
    }

    static long f(TreeNode root) {
        if (root == null)
            return 0;
        long left = f(root.left);
        long right = f(root.right);
        if (root.left != null && root.right != null)
            ans = Math.max(ans, root.data + left + right);

        return root.data + Math.max(left, right);
    }
}