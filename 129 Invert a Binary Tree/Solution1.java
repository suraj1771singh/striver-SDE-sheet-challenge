import java.util.*;

public class Solution {
    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        Stack<TreeNode<Integer>> st = new Stack<>();

        getPath(root, leaf, st);
        TreeNode<Integer> head = st.peek();
        TreeNode<Integer> par = head;
        while (!st.isEmpty()) {
            TreeNode<Integer> p = st.pop();
            if (p.right == head)
                p.right = p.left;
            p.left = null;
            head.left = p;
            head = p;

        }
        return par;
    }

    static boolean getPath(TreeNode<Integer> root, TreeNode<Integer> leaf, Stack<TreeNode<Integer>> st) {
        if (root == null)
            return false;
        st.push(root);
        if (root.data.equals(leaf.data))
            return true;
        if (getPath(root.left, leaf, st) || getPath(root.right, leaf, st))
            return true;
        st.pop();
        return false;

    }
}