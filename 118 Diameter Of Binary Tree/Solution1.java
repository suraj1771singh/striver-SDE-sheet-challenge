import java.util.*;

public class Solution {
    static int ans;

    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        ans = 0;
        longestPath(root);
        return ans;
    }

    static int longestPath(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        ans = Math.max(ans, left + right);
        return 1 + Math.max(left, right);
    }

}