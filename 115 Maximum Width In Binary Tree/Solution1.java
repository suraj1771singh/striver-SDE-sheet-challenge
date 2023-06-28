import java.util.*;
import java.util.Queue;

public class Solution {
    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            ans = Math.max(ans, k);
            while (k-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return ans;
    }
}