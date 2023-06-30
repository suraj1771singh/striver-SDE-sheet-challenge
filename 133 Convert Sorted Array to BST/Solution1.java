import java.util.*;

public class Solution {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        return f(arr, 0, n - 1);
    }

    static TreeNode<Integer> f(ArrayList<Integer> arr, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode<Integer> node = new TreeNode(arr.get(mid));
        node.left = f(arr, l, mid - 1);
        node.right = f(arr, mid + 1, r);
        return node;

    }
}