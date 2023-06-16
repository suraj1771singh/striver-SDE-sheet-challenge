import java.util.*;
import java.io.*;

class Solution {
    static List<List<String>> res;

    public static List<List<String>> partition(String s) {
        char a[] = s.toCharArray();
        res = new ArrayList<>();
        f(0, a, new ArrayList<>());
        return res;
    }

    static void f(int ind, char a[], List<String> temp) {
        int n = a.length;
        if (ind >= n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        StringBuilder s = new StringBuilder();
        for (int i = ind; i < n; i++) {
            s.append(a[i]);
            if (isPalidrome(s.toString())) {
                temp.add(new String(s.toString()));
                f(i + 1, a, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    static boolean isPalidrome(String s) {
        int l = 0, h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}