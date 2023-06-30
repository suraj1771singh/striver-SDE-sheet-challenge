public class Solution {
    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
        if (root == null)
            return false;

        if (root.data.equals(x))
            return true;
        else if (x > root.data)
            return searchInBST(root.right, x);
        else
            return searchInBST(root.left, x);
    }

}