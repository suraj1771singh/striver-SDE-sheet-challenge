import java.util.*;

public class Solution {

    static class BSTIterator {
        static Stack<TreeNode<Integer>> st;

        BSTIterator(TreeNode<Integer> root) {
            st = new Stack<>();
            pushAll(root);
        }

        // TC : O(1)
        int next() {
            TreeNode<Integer> item = st.pop();
            pushAll(item.right);
            return item.data;
        }

        // TC : O(1)
        boolean hasNext() {
            return !st.isEmpty();
        }

        void pushAll(TreeNode<Integer> root) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

        }
    }
}
// Space complexity : O(log n)