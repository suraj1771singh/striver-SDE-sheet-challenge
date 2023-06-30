public class Solution {
    static TreeNode<Integer> ans;

    public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        ans = null;
        f(root, p, q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
    }

    static void f(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q, int leftrange, int rightrange) {
        if (root == null)
            return;
        if (p.data > leftrange && p.data < rightrange && q.data > leftrange && q.data < rightrange) {
            ans = root;
            f(root.left, p, q, leftrange, root.data);
            f(root.right, p, q, root.data, rightrange);
        }
    }
}