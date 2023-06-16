import java.util.*;
import java.io.*;

class Solution {
    public static String graphColoring(int[][] mat, int m) {
        int n = mat.length;
        int color[] = new int[n];
        return f(0, color, mat, m) ? "YES" : "NO";
    }

    static boolean f(int row, int color[], int[][] mat, int m) {
        int n = mat.length;
        if (row >= n)
            return true;
        for (int k = 1; k <= m; k++) {
            if (isValid(row, k, mat, color)) {
                color[row] = k;
                if (f(row + 1, color, mat, m))
                    return true;
                color[row] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int row, int k, int mat[][], int color[]) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            if (mat[row][i] == 1 && color[i] == k)
                return false;
        }
        return true;
    }

}
