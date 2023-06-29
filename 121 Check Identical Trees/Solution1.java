public class Solution {

    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if (root1 == null || root2 == null)
            return root1 == null && root2 == null;

        boolean left = identicalTrees(root1.left, root2.left);
        boolean right = identicalTrees(root1.right, root2.right);

        if (left && right && root1.data.equals(root2.data))
            return true;
        return false;
    }

}