public class Solution {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        if (root == null)
            return -1;
        if (root.data == x || root.data == y)
            return root.data;
        int lca1 = lowestCommonAncestor(root.left, x, y);
        int lca2 = lowestCommonAncestor(root.right, x, y);
        if (lca1 != -1 && lca2 != -1)
            return root.data;
        if (lca1 != -1)
            return lca1;
        return lca2;
    }

}