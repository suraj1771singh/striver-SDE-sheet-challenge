import java.util.*;

class Solution {
    // find maximum number of overlapping
    public static int calculateMinPatforms(int at[], int dt[], int n) {

        PriorityQueue<int[]> q = new PriorityQueue<>((i, j) -> i[1] - j[1]);
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i] = new int[] { at[i], dt[i] };
        }
        Arrays.sort(a, (i, j) -> i[0] - j[0]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && a[i][0] >= q.peek()[1])
                q.poll();
            q.add(new int[] { a[i][0], a[i][1] });
            ans = Math.max(ans, q.size());
        }
        return ans;
    }
}
// Time complexity : O(n*logn)