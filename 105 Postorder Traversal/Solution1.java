import java.util.*;;

public class Solution {
    static List<Integer> list;

    public static List<Integer> getPostOrderTraversal(TreeNode root) {
        list = new ArrayList<>();
        f(root);
        return list;
    }

    static void f(TreeNode root) {
        if (root == null)
            return;

        f(root.left);
        f(root.right);
        list.add(root.data);
    }
}