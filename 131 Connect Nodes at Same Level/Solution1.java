import java.util.*;

public class Solution {
    public static void connectNodes(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int k = q.size();
            BinaryTreeNode<Integer> prev = null;
            while (k-- > 0) {
                BinaryTreeNode<Integer> node = q.poll();
                if (prev != null)
                    prev.next = node;
                prev = node;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
    }
}