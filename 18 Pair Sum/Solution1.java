import java.io.*;
import java.util.*;

class Solution {
    public static List<int[]> pairSum(int[] arr, int s) {
        int n = arr.length;
        Arrays.sort(arr);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = s - arr[i];
            int pos = binSearch(target, i + 1, n - 1, arr);
            if (pos >= i + 1 && pos <= n - 1) {
                while (pos < n && arr[pos] == target) {
                    res.add(new int[] { arr[i], arr[pos] });
                    pos++;
                }
            }
        }
        return res;

    }

    static int binSearch(int x, int l, int h, int a[]) {
        int pos = l - 1;
        while (l <= h) {
            int mid = (l + h) / 2;

            if (a[mid] >= x) {
                h = mid - 1;
                pos = mid;
            } else {
                l = mid + 1;
            }
        }
        return pos;

    }
}
// Time complexity : O(n*logn)
