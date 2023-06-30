public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;
        if (root.left != null && root.left.data > root.data)
            return false;
        if (root.right != null && root.right.data < root.data)
            return false;
        return validateBST(root.left) && validateBST(root.right);
    }

}