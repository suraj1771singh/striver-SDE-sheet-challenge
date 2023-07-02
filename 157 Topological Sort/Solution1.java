import java.util.*;
import java.util.Queue;

public class Solution {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<Integer> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[v];
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        for (ArrayList<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            indegree[b]++;
            adj.get(a).add(b);
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++)
            if (indegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int child : adj.get(node))
                if (--indegree[child] == 0)
                    q.add(child);
        }
        return res;
    }
}
