import java.util.*;

public class Solution {

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
        int dist[] = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
        for (ArrayList<Integer> edge : vec) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { 0, 0 });
        dist[0] = 0;

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();

            for (int next[] : adj.get(curr[0])) {

                if (dist[curr[0]] + next[1] < dist[next[0]]) {
                    dist[next[0]] = dist[curr[0]] + next[1];
                    pq.add(new int[] { next[0], dist[next[0]] });
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : dist)
            res.add(i);
        return res;

    }
}