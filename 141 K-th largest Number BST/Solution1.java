
public class Solution {
    static int cnt;

    public static int KthLargestNumber(TreeNode<Integer> root, int k) {
        cnt = 0;
        int n = countNodes(root);
        k = n - k + 1;
        return f(root, k);
    }

    static int countNodes(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
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
// Do it using morris traversal