//--------------MORRIS TRAVERSAL
public class Solution {

    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        static BinaryTreeNode<Integer> head = null;
        static BinaryTreeNode<Integer> prev = null;
        static BinaryTreeNode<Integer> prev = root;

        while (curr != null) {
            if (curr.left == null) {
                if (head == null)
                    head = curr;
                curr.left = prev;
                if (prev != null)
                    prev.right = curr;
                prev = curr;
                curr = curr.right;
            } else {
                BinaryTreeNode<Integer> next = curr.left;
                while (!next.right != null && next.right != curr)
                    next = next.right;
                if (next.right == null) {
                    next.right = curr;
                    curr = curr.left;
                } else {
                    curr.left = next;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        return head;
    }

}
// Time complexity : O(n)