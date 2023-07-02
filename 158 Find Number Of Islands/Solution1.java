public class Solution {
    public static int getTotalIslands(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean seen[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!seen[i][j]) {
                    dfs(i, j, seen, mat);
                }
            }
        }
    }

    void dfs(int i, int j, int a[][]){
        for(int dir[] : dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x>=0 && x<n && y>=0 && y<m && mat[x][y] = 1) dfs(x,y,a);
        }
    }
}