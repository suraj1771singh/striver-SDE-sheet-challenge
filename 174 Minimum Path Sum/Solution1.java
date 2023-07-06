
class Solution {
    static int dirs[][] = { { 1, 0 }, { 0, 1 } };
    static int n;
    static int m;

    public static int minSumPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Integer dp[][] = new Integer[n][m];
        return f(0, 0, grid, dp);
    }

    static int f(int i, int j, int[][] grid, Integer dp[][]) {
        if (i == n - 1 && j == m - 1)
            return grid[i][j];
        if (dp[i][j] != null)
            return dp[i][j];
        int sum = grid[i][j];
        int res = (int) 1e9;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < n && y >= 0 && y < m)
                res = Math.min(res, f(x, y, grid, dp));

        }
        return dp[i][j] = sum + res;
    }
}