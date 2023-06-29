import java.util.*;

public class Solution {
    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        f(root, null, true, leaf);
        return leaf;
    }

    static boolean f(TreeNode<Integer> root, TreeNode<Integer> parent, boolean isLeftChild, TreeNode<Integer> target) {

        if (root == null)
            return false;

        TreeNode<Integer> leftChild = root.left;
        TreeNode<Integer> rightchild = root.right;

        // reverse edges
        root.left = parent;
        root.right = leftChild;

        if (root.data == target.data) {
            // System.out.println(root.data);
            return true;
        }

        if (f(leftChild, root, true, target))
            return true;
        if (f(rightchild, root, false, target))
            return true;

        // reverse edges again as original
        root.left = leftChild;
        root.right = rightchild;
        return false;
    }
}
