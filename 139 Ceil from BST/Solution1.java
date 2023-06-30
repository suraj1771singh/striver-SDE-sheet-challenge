public class Solution {

    public static int findCeil(TreeNode<Integer> node, int x) {
        int ans = -1;
        TreeNode<Integer> curr = node;
        while (curr != null) {
            if (curr.data < x)
                curr = curr.right;
            else {
                ans = curr.data;
                curr = curr.left;
            }
        }
        return ans;

    }
}