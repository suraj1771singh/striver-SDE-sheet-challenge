import java.util.*;
import java.io.*;

class Solution {
    static List<String> res;

    public static List<String> findPermutations(String s) {
        res = new ArrayList<>();
        f(0, s.toCharArray());
        return res;
    }

    static void f(int ind, char a[]) {
        int n = a.length;
        if (ind >= n) {
            res.add(new String(a));
            return;
        }

        for (int i = ind; i < n; i++) {
            swap(ind, i, a);
            f(ind + 1, a);
            swap(ind, i, a);
        }
    }

    private static void swap(int i, int j, char[] a) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}