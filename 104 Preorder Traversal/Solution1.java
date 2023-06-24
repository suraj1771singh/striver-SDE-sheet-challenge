import java.util.*;

public class Solution {
    static List<Integer> list;

    public static List<Integer> getPreOrderTraversal(TreeNode root) {
        list = new ArrayList<>();
        f(root);
        return list;
    }

    static void f(TreeNode root) {
        if (root == null)
            return;
        list.add(root.data);
        f(root.left);
        f(root.right);
    }
}