import java.util.*;

class BSTIterator {
    private Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    boolean reverse = true;

    public BSTIterator(BinaryTreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        BinaryTreeNode tmpNode = stack.pop();
        if (reverse == false)
            pushAll(tmpNode.right);
        else
            pushAll(tmpNode.left);
        return tmpNode.data;
    }

    private void pushAll(BinaryTreeNode node) {
        while (node != null) {
            stack.push(node);
            if (reverse == true)
                node = node.right;
            else
                node = node.left;

        }
    }
}

class Solution {
    public static boolean pairSumBst(BinaryTreeNode root, int k) {
        if (root == null)
            return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k)
                return true;
            else if (i + j < k)
                i = l.next();
            else
                j = r.next();
        }
        return false;
    }
}
// Time complexity : O(1)
// Space complexity : O(log n)