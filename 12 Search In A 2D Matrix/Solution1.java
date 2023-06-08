import java.util.ArrayList;

class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int n = mat.size();
        int m = mat.get(0).size();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = mat.get(i).get(m - 1);
        int pos = binSearch(target, a);
        if (pos < n && a[pos] == target)
            return true;
        if (pos >= n)
            return false;
        a = new int[m];
        for (int i = 0; i < m; i++)
            a[i] = mat.get(pos).get(i);
        pos = binSearch(target, a);
        if (pos < m && a[pos] == target)
            return true;
        return false;
    }

    static int binSearch(int x, int a[]) {
        int l = 0;
        int h = a.length - 1;
        int pos = 0;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x) {
                pos = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }
}
// Time complexity: O(n + M)
