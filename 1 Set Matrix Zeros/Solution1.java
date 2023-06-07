import java.io.*;
import java.util.*;

class Solution {
    public static void setZeros(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int row : rows) {
            for (int i = 0; i < m; i++)
                matrix[row][i] = 0;
        }
        for (int col : cols) {
            for (int i = 0; i < n; i++)
                matrix[i][col] = 0;
        }
    }

}