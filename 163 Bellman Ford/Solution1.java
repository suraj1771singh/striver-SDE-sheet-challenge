import java.util.*;

public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int dist[] = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src - 1] = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < m; j++) {
                ArrayList<Integer> edge = edges.get(j);
                int u = edge.get(0) - 1;
                int v = edge.get(1) - 1;
                int w = edge.get(2);
                if (dist[u] != (int) 1e9 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    flag = true;
                }
            }
            if (!flag)
                return dist[dest - 1];
        }
        return dist[dest - 1];
    }

}
