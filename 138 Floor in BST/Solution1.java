public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        int ans = -1;
        TreeNode<Integer> curr = root;
        while (curr != null) {
            if (curr.data > X)
                curr = curr.left;
            else {
                ans = curr.data;
                curr = curr.right;
            }
        }
        return ans;
    }
}