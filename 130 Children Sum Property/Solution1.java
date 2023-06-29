public class Solution {
    public static void changeTree(BinaryTreeNode<Integer> root) {
        f(root);
    }

    static void f(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        int sum = 0;
        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;

        if (sum >= root.data)
            root.data = sum;
        else {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data;
        }
        f(root.left);
        f(root.right);

        // when comming back
        if (root.left != null && root.right != null)
            root.data = root.left.data + root.right.data;
        else if (root.left != null)
            root.data = root.left.data;
        else if (root.right != null)
            root.data = root.right.data;
    }
}