import java.io.*;
import java.util.*;

class Solution {

    public static String fourSum(int[] arr, int target, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // two sum problem
                int tgt = target - arr[i] - arr[j];
                if (twosum(j + 1, n - 1, tgt, arr))
                    return "Yes";
            }
        }
        return "No";
    }

    public static boolean twosum(int i, int j, int target, int a[]) {
        while (i < j) {
            if (a[i] + a[j] == target)
                return true;
            else if (a[i] + a[j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
// Time complexity : O(n^3)
