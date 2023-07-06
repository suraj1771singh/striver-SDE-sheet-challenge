public class Solution {

    public static int editDistance(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        Integer dp[][] = new Integer[n][m];
        return f(n - 1, m - 1, str1, str2, dp);
    }

    static int f(int i, int j, String s1, String s2, Integer dp[][]) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (dp[i][j] != null)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = f(i - 1, j - 1, s1, s2, dp);
        else {
            int delete = f(i - 1, j, s1, s2, dp);
            int replace = f(i - 1, j - 1, s1, s2, dp);
            int insert = f(i, j - 1, s1, s2, dp);
            return dp[i][j] = 1 + Math.min(delete, Math.min(replace, insert));
        }
    }
}
// Time complexity : O(n*m)