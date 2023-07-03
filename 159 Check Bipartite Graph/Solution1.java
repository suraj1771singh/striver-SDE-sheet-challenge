import java.util.*;
import java.util.Queue;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

        Queue<Integer> q = new LinkedList<>();
        int n = edges.size();
        q.add(0);
        int color[] = new int[n];
        color[0] = 1;
        while (!q.isEmpty()) {
            int k = q.size();
            while (k-- > 0) {
                int node = q.poll();
                for (int i = 0; i < n; i++) {
                    if (edges.get(node).get(i) == 0 || node == i)
                        continue;
                    else if (color[i] == color[node])
                        return false;
                    else if (color[i] == 0) {
                        color[i] = -1 * color[node];
                        q.add(i);
                    }
                }
            }

        }
        return true;
    }
}