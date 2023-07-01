public class Solution {

    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> curr = root;
        while (curr != null) {
            if (curr.left == null) {
                BinaryTreeNode<Integer> next = curr.right;
                curr.right = next;
                next.l
                curr = curr.right;
            } else {

            }
        }
    }
}