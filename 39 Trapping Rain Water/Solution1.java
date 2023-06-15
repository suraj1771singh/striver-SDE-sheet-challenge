import java.util.*;
import java.io.*;

class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        long right[] = new long[n];// highest tower to right side
        long left[] = new long[n];// highest tower to left side
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans += Math.max(0, Math.min(left[i - 1], right[i + 1]) - arr[i]);
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)