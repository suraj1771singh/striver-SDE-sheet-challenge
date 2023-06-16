import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> res;

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[0][i] = 1;
            f(1, a, n);
            a[0][i] = 0;
        }
        return res;
    }

    static void f(int row, int[][] a, int n) {
        if (row >= n) {
            ArrayList<Integer> temp = convertToArrayList(a);
            res.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, a)) {
                a[row][col] = 1;
                f(row + 1, a, n);
                a[row][col] = 0;
            }
        }
    }

    private static ArrayList<Integer> convertToArrayList(int[][] a) {
        ArrayList<Integer> temp = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                temp.add(a[i][j]);
        }
        return temp;
    }

    static boolean isValid(int r, int c, int a[][]) {

        // check left digonal
        int i = r, j = c, n = a.length;
        while (i >= 0 && j >= 0) {
            if (a[i][j] == 1)
                return false;
            i--;
            j--;
        }
        // check right diagonal
        i = r;
        j = c;
        while (i >= 0 && j < n) {
            if (a[i][j] == 1)
                return false;
            i--;
            j++;
        }
        // vertical above col
        i = r;
        j = c;
        while (i >= 0) {
            if (a[i][j] == 1)
                return false;
            i--;
        }
        return true;
    }
}