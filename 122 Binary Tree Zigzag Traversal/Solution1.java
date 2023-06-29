import java.util.*;
import java.io.*;
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

public class Solution {
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                BinaryTreeNode<Integer> node = flag ? q.pollLast() : q.pollFirst();
                res.add(node.data);
                if (!flag) {
                    if (node.left != null)
                        q.addLast(node.left);
                    if (node.right != null)
                        q.addLast(node.right);
                } else {
                    if (node.right != null)
                        q.addFirst(node.right);
                    if (node.left != null)
                        q.addFirst(node.left);
                }
            }
            flag = !flag;
        }
        return res;

    }
}
