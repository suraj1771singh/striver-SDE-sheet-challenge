import java.util.*;

public class Solution {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[][] dist = new int[n][n];
        for (int r[] : dist)
            Arrays.fill(r, (int) 1e9);
        for (int i = 0; i < n; i++)
            dist[i][i] = 0;
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            int w = edge.get(2);
            dist[u][v] = w;
            // dist[v][u] = w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != (int) 1e9 && dist[k][j] != (int) 1e9)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist[src - 1][dest - 1];
    }

}
