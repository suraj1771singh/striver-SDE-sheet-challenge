import java.util.*;

class Solution {
    public static int maximumProfit(ArrayList<Integer> prices) {
        int n = prices.size();
        Integer dp[][] = new Integer[n][2];
        int ans = f(0, 1, prices, dp);
        return ans < 0 ? 0 : ans;
    }

    static int f(int ind, int buy, ArrayList<Integer> prices, Integer dp[][]) {
        if (ind >= prices.size())
            return -(int) 1e9;

        if (dp[ind][buy] != null)
            return dp[ind][buy];
        if (buy == 1) {
            int pick = -prices.get(ind) + f(ind + 1, 1 - buy, prices, dp);
            int notpick = f(ind + 1, buy, prices, dp);
            return dp[ind][buy] = Math.max(pick, notpick);
        } else {
            // sell or not sell
            return dp[ind][buy] = Math.max(prices.get(ind), f(ind + 1, buy, prices, dp));
        }
    }
}