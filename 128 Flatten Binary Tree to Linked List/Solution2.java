// USING MORRIS TRAVERSAL TECHNIQUE

public class Solution {
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {
        TreeNode<Integer> curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode<Integer> prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        return root;
    }

}
// Time complexity : O(2N)
// Space complexit : O(1)