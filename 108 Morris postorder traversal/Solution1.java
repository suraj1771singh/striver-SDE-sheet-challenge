import java.util.*;

//---------------MORRIS TRAVERSAL
public class Solution {
    static List<Integer> list;

    public static List<Integer> getPostOrderTraversal(TreeNode root) {
        list = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            // case 1 :
            if (curr.right == null) {
                list.add(curr.data);
                curr = curr.left;
            } else {
                // case 2 :
                // go to the leftmost child of right subtree
                TreeNode prev = curr.right;
                while (prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }
                // case 2.1 : when leftmost is not connected to curr

                if (prev.left == null) {
                    prev.left = curr;
                    list.add(curr.data);
                    curr = curr.right;
                }
                // case 2.2 : when leftmost is already connected to curr
                else {
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(list);
        return list;
    }

}
// Time complexity : O(2*N)
// Space complexity : O(1)