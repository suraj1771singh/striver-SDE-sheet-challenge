import java.util.*;
import java.util.Queue;

public class Solution {
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            res.add(q.peek().data);
            while (size-- > 0) {
                TreeNode<Integer> node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

            }
        }
        return res;
    }
}