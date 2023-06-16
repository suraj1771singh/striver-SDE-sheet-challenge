class Solution {

    public static boolean isItSudoku(int a[][]) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(i, j, k, a)) {
                            a[i][j] = k;
                            if (isItSudoku(a))
                                return true;
                            a[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }

    static boolean isValid(int row, int col, int num, int a[][]) {
        // same row
        for (int i = 0; i < 9; i++) {
            if (a[row][i] == num)
                return false;
        }
        // same col
        for (int i = 0; i < 9; i++) {
            if (a[i][col] == num)
                return false;
        }
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (a[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}
