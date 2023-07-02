import java.util.*;

public class Solution {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            adj.get(u).add(v);
        }
        boolean seen[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!seen[i])
                if (dfs(i, seen, new boolean[n], adj))
                    return true;
        }
        return false;
    }

    static boolean dfs(int node, boolean seen[], boolean stack[], List<List<Integer>> adj) {
        seen[node] = true;
        stack[node] = true;
        for (int child : adj.get(node)) {
            if (!seen[child]) {
                if (dfs(child, seen, stack, adj))
                    return true;
            } else if (stack[child])
                return true;

        }
        stack[node] = false;
        return false;
    }
}
