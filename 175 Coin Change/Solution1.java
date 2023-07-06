
public class Solution {

    public static long countWaysToMakeChange(int denominations[], int value) {
        int n = denominations.length;

        Long dp[][] = new Long[n][value + 1];
        return f(n - 1, denominations, value, dp);
    }

    static long f(int ind, int deno[], int val, Long dp[][]) {
        if (val == 0)
            return 1;
        if (ind == 0)
            return val % deno[ind] == 0 ? 1 : 0;
        if (dp[ind][val] != null)
            return dp[ind][val];
        long p = 0, np = 0;
        if (val - deno[ind] >= 0)
            p = f(ind, deno, val - deno[ind], dp);

        np = f(ind - 1, deno, val, dp);
        return dp[ind][val] = p + np;
    }

}
// Time complexity : O(n*val)