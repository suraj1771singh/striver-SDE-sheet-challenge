public class Solution {
    public static int cutRod(int price[], int n) {
        Integer dp[] = new Integer[n + 1];
        return f(n, price, dp);
    }

    static int f(int n, int[] prices, Integer dp[]) {
        if (dp[n] != null)
            return dp[n];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, prices[i - 1] + f(n - i, prices, dp));
        }
        return dp[n] = res;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n)