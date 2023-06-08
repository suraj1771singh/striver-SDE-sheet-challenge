import java.util.*;
import java.io.*;

class Solution {
    static int dirs[][] = { { 1, 0 }, { 0, 1 } };

    public static int uniquePaths(int m, int n) {
        Integer dp[][] = new Integer[m][n];
        return f(0, 0, m, n, dp);
    }

    public static int f(int i, int j, int m, int n, Integer dp[][]) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n) {
                ans += f(x, y, m, n, dp);
            }
        }
        return dp[i][j] = ans;
    }

}
// Time complexity : O(n*m)