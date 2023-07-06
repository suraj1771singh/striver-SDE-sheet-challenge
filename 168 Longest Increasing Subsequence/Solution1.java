public class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        Integer dp[][] = new Integer[n + 1][n + 1];
        return f(n - 1, n, arr, dp);
    }

    static int f(int curr, int prev, int a[], Integer dp[][]) {
        if (curr < 0)
            return 0;
        if (dp[curr][prev] != null)
            return dp[curr][prev];
        int p = 0, np = 0;
        if (prev == a.length || a[curr] < a[prev])
            p = 1 + f(curr - 1, curr, a, dp);
        np = f(curr - 1, prev, a, dp);
        return dp[curr][prev] = Math.max(p, np);
    }

}
// Time complexity : O(n^2)
// Space complexity : O(n^2)