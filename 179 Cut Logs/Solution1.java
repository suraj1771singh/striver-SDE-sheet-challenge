
public class Solution {

    public static int cutLogs(int k, int n) {
        Integer dp[][] = new Integer[k + 1][n + 1];
        return f(k, n, dp);
    }

    static int f(int k, int n, Integer dp[][]) {
        if (n <= 1)
            return n;
        if (k == 1)
            return n;
        if (dp[k][n] != null)
            return dp[k][n];
        int ans = (int) 1e9;
        // linear search
        // for(int i=1; i<=n; i++){
        // int temp = 1 + Math.max(f(k-1,i-1), f(k,n-i));
        // ans = Math.min(ans, temp);
        // }
        // Binary search
        int l = 1, h = n;
        while (l <= h) {
            int mid = (l + h) / 2;
            int broken = f(k - 1, mid - 1, dp);
            int notbroken = f(k, n - mid, dp);
            int temp = 1 + Math.max(broken, notbroken);
            if (broken > notbroken)
                h = mid - 1;
            else
                l = mid + 1;
            ans = Math.min(ans, temp);
        }

        return dp[k][n] = ans;
    }

}
// TIme complexity : O(n*k*logn)
