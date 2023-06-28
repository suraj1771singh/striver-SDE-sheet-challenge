import java.util.*;
import java.io.*;

public class Solution {
    static List<int[]> a[];

    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        a = new ArrayList[6000];
        f(root, 0, 3000);
        for (int i = 0; i < 6000; i++) {
            if (a[i] == null)
                continue;
            Collections.sort(a[i], (p, q) -> p[0] - q[0]);
            for (int num[] : a[i])
                res.add(num[2]);
        }
        return res;
    }

    static void f(TreeNode<Integer> root, int r, int c) {
        if (root == null)
            return;
        if (a[c] == null)
            a[c] = new ArrayList<>();
        a[c].add(new int[] { r, c, root.data });
        f(root.left, r + 1, c - 1);
        f(root.right, r + 1, c + 1);
    }
}
