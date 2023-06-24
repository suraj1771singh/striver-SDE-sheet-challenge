import java.util.*;

class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int res[] = new int[n];
        Arrays.fill(res, -(int) 1e9);
        for (int wind = 1; wind <= n; wind++) {
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!q.isEmpty() && a[q.peekLast()] >= a[i])
                    q.pollLast();
                q.addLast(i);
                while (q.peekFirst() <= i - wind)
                    q.pollFirst();
                if (i >= wind - 1)
                    res[wind - 1] = Math.max(res[wind - 1], a[q.peekFirst()]);
            }
        }
        return res;
    }
}
// Time complexity : O(n^2)