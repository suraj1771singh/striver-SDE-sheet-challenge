
class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        Boolean dp[][] = new Boolean[n][k + 1];
        return f(n - 1, k, arr, dp);
    }

    static boolean f(int ind, int k, int a[], Boolean dp[][]) {
        if (k == 0)
            return true;
        if (ind < 0)
            return false;
        if (dp[ind][k] != null)
            return dp[ind][k];
        boolean p = false, np = false;
        if (k - a[ind] >= 0)
            p = f(ind - 1, k - a[ind], a, dp);
        np = f(ind - 1, k, a, dp);
        return dp[ind][k] = p || np;
    }
}
// Time complexity : O(n*k)
