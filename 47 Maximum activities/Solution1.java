import java.util.*;

class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        int n = start.size();
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i] = new int[] { start.get(i), end.get(i) };
        }
        Arrays.sort(a, (i, j) -> i[1] == j[1] ? i[0] - j[0] : i[1] - j[1]);
        int cnt = 1;
        int prevend = a[0][1];
        for (int i = 1; i < n; i++) {
            if (prevend <= a[i][0]) {
                cnt++;
                prevend = a[i][1];
            }
        }
        return cnt;
    }
}
// Time complexity : O(n*logn)