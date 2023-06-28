import java.util.*;

public class Solution {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        int max = 0;
        int min = 0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int k = q.size();
            while (k-- > 0) {
                Pair p = q.poll();
                if (!map.containsKey(p.dist))
                    map.put(p.dist, p.node.val);
                min = Math.min(min, p.dist);
                max = Math.max(max, p.dist);
                if (p.node.left != null)
                    q.add(new Pair(p.node.left, p.dist - 1));
                if (p.node.right != null)
                    q.add(new Pair(p.node.right, p.dist + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }

}

class Pair {
    BinaryTreeNode node;
    Integer dist;

    Pair(BinaryTreeNode a, Integer b) {
        node = a;
        dist = b;
    }
}