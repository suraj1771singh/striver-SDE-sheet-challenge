import java.util.*;
import java.io.*;

public class Solution {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        f(root, x, path1);
        f(root, y, path2);
        int i = 0, j = 0, ans = root.data;
        while (i < path1.size() && j < path2.size() && path1.get(i) == path2.get(j)) {
            ans = path1.get(i);
            i++;
            j++;
        }
        return ans;
    }

    static boolean f(TreeNode<Integer> root, int x, List<Integer> path) {
        if (root == null)
            return false;
        path.add(root.data);
        if (root.data == x)
            return true;
        if (f(root.left, x, path) || f(root.right, x, path))
            return true;
        path.remove(path.size() - 1);
        return false;

    }
}
