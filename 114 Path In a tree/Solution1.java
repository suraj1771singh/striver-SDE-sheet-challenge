
import java.util.*;

public class Solution {
    static ArrayList<Integer> res;

    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        res = new ArrayList<>();
        f(root, x);
        return res;
    }

    static boolean f(TreeNode root, int x) {
        if (root == null)
            return false;
        res.add(root.data);
        if (root.data == x)
            return true;
        if (f(root.left, x) || f(root.right, x))
            return true;
        res.remove(res.size() - 1);
        return false;

    }
}