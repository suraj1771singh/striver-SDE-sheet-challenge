
import java.util.*;

class Solution {
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = matrix.size();
        int m = matrix.get(0).size();
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { matrix.get(i).get(m - 1), i, m - 1 });
        }
        int ttl = m * n;
        if (ttl % 2 == 0) {
            int k = ttl / 2 - 1;
            while (k-- > 0 && !pq.isEmpty()) {
                int item[] = pq.poll();
                int nc = item[2] - 1;
                int r = item[1];
                if (nc >= 0)
                    pq.add(new int[] { matrix.get(r).get(nc), r, nc });
            }
            int item1[] = pq.poll();
            int item2[] = pq.poll();
            return (item1[0] + item2[0]) / 2;

        } else {
            int k = ttl / 2;
            while (k-- > 0 && !pq.isEmpty()) {
                int item[] = pq.poll();
                int nc = item[2] - 1;
                int r = item[1];
                if (nc >= 0)
                    pq.add(new int[] { matrix.get(r).get(nc), r, nc });
            }
            return pq.peek()[0];

        }
    }
}