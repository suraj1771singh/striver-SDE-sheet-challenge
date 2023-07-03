public class Solution {
    static int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
    static int n;
    static int m;

    public static int getTotalIslands(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    cnt++;
                    dfs(i, j, mat);
                }
            }
        }
        return cnt;
    }

    static void dfs(int i, int j, int a[][]) {
        a[i][j] = 0;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] == 1)
                dfs(x, y, a);
        }
    }
}