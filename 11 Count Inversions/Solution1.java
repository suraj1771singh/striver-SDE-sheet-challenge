import java.util.*;
import java.io.*;

class Solution {
    static long ans;

    public static long getInversions(long arr[], int n) {
        ans = 0;
        mergesort(0, n - 1, arr);
        return ans;
    }

    static void mergesort(int l, int r, long[] a) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergesort(l, mid, a);
            mergesort(mid + 1, r, a);
            merge(l, mid, r, a);
        }
    }

    static void merge(int l, int mid, int r, long a[]) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        long a1[] = new long[n1];
        long a2[] = new long[n2];
        for (int i = 0; i < n1; i++)
            a1[i] = a[l + i];

        for (int i = 0; i < n2; i++)
            a2[i] = a[mid + 1 + i];
        int k = l, i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j])
                a[k++] = a1[i++];
            else {
                a[k++] = a2[j++];
                ans += n1 - i;
            }
        }
        while (i < n1)
            a[k++] = a1[i++];
        while (j < n2)
            a[k++] = a2[j++];
    }
}
// Time complexity : O(n*log n)
// Space complexity : O(n)