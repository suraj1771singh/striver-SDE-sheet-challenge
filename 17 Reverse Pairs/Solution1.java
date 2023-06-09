import java.util.*;

//---------------------USING MERGE SORT
class Solution {
    static int ans;

    public static int reversePairs(ArrayList<Integer> arr) {
        ans = 0;
        mergesort(0, arr.size() - 1, arr);
        return ans;
    }

    private static void mergesort(int l, int h, ArrayList<Integer> arr) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergesort(l, mid, arr);
            mergesort(mid + 1, h, arr);
            merge(l, mid, h, arr);
        }
    }

    private static void merge(int l, int mid, int h, ArrayList<Integer> a) {
        int n1 = mid - l + 1;
        int n2 = h - mid;
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        for (int i = 0; i < n1; i++)
            a1.add(a.get(l + i));

        for (int i = 0; i < n2; i++)
            a2.add(a.get(mid + 1 + i));

        int k = l, i = 0, j = 0;

        // ----- count pairs
        for (; i < n1; i++) {
            while (j < n2 && a1.get(i) > 2 * a2.get(j))
                j++;
            ans += j;
        }
        // ----------------

        i = 0;
        j = 0;
        while (i < n1 && j < n2) {
            if (a1.get(i) > a2.get(j))
                a.set(k++, a2.get(j++));
            else
                a.set(k++, a1.get(i++));

        }
        while (i < n1)
            a.set(k++, a1.get(i++));
        while (j < n2)
            a.set(k++, a2.get(j++));
    }
}
// Time complexity : O(n*logn)