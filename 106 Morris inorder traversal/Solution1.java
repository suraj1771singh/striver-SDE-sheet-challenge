import java.util.*;

//---------------MORRIS TRAVERSAL
public class Solution {
    static List<Integer> list;

    public static List<Integer> getInOrderTraversal(TreeNode root) {
        list = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            // case 1 :
            if (curr.left == null) {
                list.add(curr.data);
                curr = curr.right;
            } else {
                // case 2 :
                // go to the rightmost child of left subtree
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // case 2.1 : when righmost is not connected to curr

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                // case 2.2 : when righmost is already connected to curr
                else {
                    prev.right = null;
                    list.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return list;
    }

}
// Time complexity : O(2*N)
// Space complexity : O(1)