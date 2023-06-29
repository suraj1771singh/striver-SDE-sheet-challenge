public class Solution {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        post(root, s1);
        pre(root, s2);
        if (s1.toString().equals(s2.toString()))
            return true;
        return false;
    }

    static void post(BinaryTreeNode<Integer> root, StringBuilder s) {
        if (root == null)
            return;
        post(root.left, s);
        s.append(root.data + "-");
        post(root.right, s);

    }

    static void pre(BinaryTreeNode<Integer> root, StringBuilder s) {
        if (root == null)
            return;

        pre(root.right, s);
        s.append(root.data + "-");
        pre(root.left, s);
    }
}