import java.util.*;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        Integer dp[][] = new Integer[n + 1][n + 1];
        return f(n - 1, n, rack, dp);
    }

    static int f(int curr, int prev, ArrayList<Integer> a, Integer dp[][]) {
        if (curr < 0)
            return 0;
        if (dp[curr][prev] != null)
            return dp[curr][prev];
        int p = 0, np = 0;
        if (prev == a.size() || a.get(curr) < a.get(prev))
            p = a.get(curr) + f(curr - 1, curr, a, dp);
        np = f(curr - 1, prev, a, dp);
        return dp[curr][prev] = Math.max(p, np);
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)