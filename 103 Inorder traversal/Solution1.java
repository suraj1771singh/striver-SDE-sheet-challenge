import java.util.*;

public class Solution {
    static List<Integer> list;

    public static List<Integer> getInOrderTraversal(TreeNode root) {
        list = new ArrayList<>();
        f(root);
        return list;
    }

    static void f(TreeNode root) {
        if (root == null)
            return;
        f(root.left);
        list.add(root.data);
        f(root.right);
    }
}