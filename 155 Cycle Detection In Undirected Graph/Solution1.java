import java.util.*;

public class Solution {

    public static String cycleDetection(int[][] edges, int n, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0] - 1).add(edge[1] - 1);
            adj.get(edge[1] - 1).add(edge[0] - 1);
        }
        boolean seen[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (seen[i])
                continue;
            if (dfs(i, seen, -1, adj))
                return "Yes";
        }
        return "No";
    }

    static boolean dfs(int node, boolean seen[], int parent, List<List<Integer>> adj) {

        seen[node] = true;

        for (int child : adj.get(node)) {
            if (!seen[child]) {
                if (dfs(child, seen, node, adj))
                    return true;
            } else if (child != parent)
                return true;
        }

        return false;
    }

}