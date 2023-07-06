import java.util.*;

public class Solution {
    public static int jobScheduling(int[][] jobs) {
        int n = jobs.length;
        int m = 0;// max possible time
        for (int i = 0; i < n; i++)
            m = Math.max(m, jobs[i][0]);
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);
        int map[] = new int[m + 1];
        Arrays.fill(map, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int dead = jobs[i][0];
            int profit = jobs[i][1];
            while (dead > 0 && map[dead] != -1) {
                dead--;
            }
            if (dead > 0) {
                ans += profit;
                map[dead] = i;
            }
        }
        return ans;

    }
}
// Time complexity : O(n * max(deadtime))
