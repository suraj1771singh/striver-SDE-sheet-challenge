import java.util.*;

class Solution {
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {

        int n = matrix.size();
        int m = matrix.get(0).size();
        int l = 1, h = (int) 1e9;
        while (l <= h) {
            int mid = (l + h) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++)
                cnt += countsmaller(mid, matrix.get(i));

            if (cnt <= (n * m) / 2) {
                l = mid + 1;
            } else
                h = mid - 1;

        }
        return l;

    }

    private static int countsmaller(int x, ArrayList<Integer> a) {
        int l = 0, h = a.size() - 1;
        while (l <= h) {
            int mid = (l + h) >> 1;
            if (a.get(mid) <= x) {
                l = mid + 1;
            } else
                h = mid - 1;
        }
        return l;
    }
}
