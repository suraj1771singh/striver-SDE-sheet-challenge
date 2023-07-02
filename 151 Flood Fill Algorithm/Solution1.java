import java.util.*;

public class Solution {

    public static int directions[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void dfs(int arr[][], int i, int j, int from, int to) {
        int n = arr.length, m = arr[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || arr[i][j] != from)
            return;
        arr[i][j] = -to;
        for (int dir[] : directions)
            dfs(arr, i + dir[0], j + dir[1], from, to);
    }

    public static int[][] floodFill(int[][] arr, int x, int y, int to) {
        // Write your code here
        int from = arr[x][y];
        dfs(arr, x, y, from, to);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == -to)
                    arr[i][j] = to;
            }
        }
        return arr;
    }
}
