public class Solution {

    public static int lcs(String s, String t) {
        int n = s.length(), m = t.length();
        Integer dp[][] = new Integer[n][m];
        return f(n - 1, m - 1, s, t, dp);
    }

    static int f(int i, int j, String s, String t, Integer dp[][]) {
        if (j < 0 || i < 0)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j))
            dp[i][j] = 1 + f(i - 1, j - 1, s, t, dp);
        else
            dp[i][j] = Math.max(f(i - 1, j, s, t, dp), f(i, j - 1, s, t, dp));
        return dp[i][j];
    }

}
// Time complexity : O(n*m)
// Space complexity : O(n*m)