
import java.util.*;

public class Solution {
    static int ans;

    public static int largestBST(TreeNode<Integer> root) {
        ans = 0;
        f(root);
        return ans;
    }

    static int[] f(TreeNode<Integer> root) {
        // [max, min, size]
        if (root == null)
            return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 };

        int left[] = f(root.left);
        int right[] = f(root.right);
        int max = root.data;
        int min = root.data;
        int size = -1;
        if (left[2] == -1 || right[2] == -1)
            return new int[] { max, min, -1 };

        if (left[0] < root.data && right[1] > root.data) {
            min = Math.min(min, left[1]);
            max = Math.max(max, right[0]);
            size = 1 + left[2] + right[2];
            ans = Math.max(ans, size);
            return new int[] { max, min, size };
        } else
            return new int[] { max, min, -1 };

    }
}
// Time complexity : O(n)