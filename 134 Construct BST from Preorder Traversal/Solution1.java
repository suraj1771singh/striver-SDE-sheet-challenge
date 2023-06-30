public class Solution {

    public static TreeNode<Integer> preOrderTree(int[] preOrder) {
        TreeNode<Integer> root = null;
        for (int num : preOrder)
            root = insertNode(root, num);
        return root;
    }

    static TreeNode<Integer> insertNode(TreeNode<Integer> root, int num) {
        if (root == null)
            return new TreeNode(num);
        else if (root.data > num)
            root.left = insertNode(root.left, num);
        else
            root.right = insertNode(root.right, num);
        return root;
    }

}