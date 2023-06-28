import java.util.*;
import java.util.Stack;

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            Pair p = st.peek();
            if (p.cnt == 1) {
                st.peek().cnt++;
                preorder.add(p.node.data);
                if (p.node.left != null)
                    st.push(new Pair(p.node.left, 1));
            } else if (p.cnt == 2) {
                st.peek().cnt++;
                inorder.add(p.node.data);
                if (p.node.right != null)
                    st.push(new Pair(p.node.right, 1));
            } else {
                postorder.add(p.node.data);
                st.pop();
            }
        }
        res.add(inorder);
        res.add(preorder);
        res.add(postorder);
        return res;
    }
}

class Pair {
    BinaryTreeNode<Integer> node;
    int cnt;

    Pair(BinaryTreeNode<Integer> a, int b) {
        node = a;
        cnt = b;
    }