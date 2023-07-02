import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        for (ArrayList<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean seen[] = new boolean[v];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!seen[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i, seen, adj, temp);
                res.add(temp);
            }
        }
        return res;
    }

    static void dfs(int node, boolean[] seen, List<List<Integer>> adj, ArrayList<Integer> temp) {
        seen[node] = true;
        temp.add(node);
        for (int child : adj.get(node))
            if (!seen[child])
                dfs(child, seen, adj, temp);
    }
}