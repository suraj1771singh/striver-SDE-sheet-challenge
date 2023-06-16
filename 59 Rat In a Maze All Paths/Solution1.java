import java.util.*;
import java.io.*;

class Solution {
    static int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static ArrayList<ArrayList<Integer>> res;

    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        res = new ArrayList<>();
        f(0, 0, maze);
        return res;
    }

    static void f(int i, int j, int a[][]) {
        int n = a.length;
        if (i == n - 1 && j == n - 1) {
            a[i][j] = 2;
            ArrayList<Integer> temp = convertToArrayList(a);
            res.add(temp);
            a[i][j] = 1;
            return;
        }
        int val = a[i][j];
        a[i][j] = 2;
        for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < n && y >= 0 && y < n && a[x][y] == 1)
                f(x, y, a);

        }
        a[i][j] = val;
    }

    static ArrayList<Integer> convertToArrayList(int a[][]) {

        ArrayList<Integer> res = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 2)
                    res.add(1);
                else
                    res.add(0);
            }

        return res;
    }

}