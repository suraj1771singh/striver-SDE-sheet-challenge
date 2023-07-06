import java.util.*;;

public class Solution {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        Integer dp[][] = new Integer[n][w + 1];
        return f(n - 1, w, values, weights, dp);
    }

    static int f(int ind, int w, ArrayList<Integer> values, ArrayList<Integer> weights, Integer dp[][]) {
        if (ind < 0)
            return 0;
        if (dp[ind][w] != null)
            return dp[ind][w];
        int p = 0, np = 0;
        if (w - weights.get(ind) >= 0)
            p = values.get(ind) + f(ind - 1, w - weights.get(ind), values, weights, dp);
        np = f(ind - 1, w, values, weights, dp);
        return dp[ind][w] = Math.max(p, np);
    }
}