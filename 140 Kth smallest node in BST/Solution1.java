public class Solution {
    static int cnt;

    public static int kthSmallest(TreeNode<Integer> root, int k) {
        cnt = 0;
        return f(root, k);
    }

    static int f(TreeNode<Integer> root, int k) {

        if (root == null)
            return -1;
        int left = f(root.left, k);
        if (left != -1)
            return left;
        cnt++;
        if (cnt == k)
            return root.data;
        int right = f(root.right, k);
        return right;
    }

}
