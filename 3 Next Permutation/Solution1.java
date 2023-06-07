import java.util.*;

class Solution {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> perm) {
        int n = perm.size();
        for (int i = n - 2; i >= 0; i--) {
            if (perm.get(i + 1) > perm.get(i)) {

                // found dip point and now find point very next greater then dip pt
                for (int j = n - 1; j > i; j--) {
                    if (perm.get(j) > perm.get(i)) {

                        // swap these i and j
                        int temp = perm.get(i);
                        perm.set(i, perm.get(j));
                        perm.set(j, temp);

                        // reverse [i+1, n-1]
                        reverse(i + 1, n - 1, perm);
                        return perm;
                    }
                }
            }
        }
        reverse(0, n - 1, perm);
        return perm;
    }

    public static void reverse(int l, int r, ArrayList<Integer> a) {
        while (l < r) {
            int temp = a.get(l);
            a.set(l, a.get(r));
            a.set(r, temp);
            l++;
            r--;
        }
    }
}