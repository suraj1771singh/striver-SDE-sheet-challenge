import java.util.*;
import java.io.*;
import java.util.ArrayList;

class Solution {
    static Set<String> dict;
    static ArrayList<String> res;

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        // Write your code here.
        dict = new HashSet<>();
        res = new ArrayList<>();
        for (String str : dictionary)
            dict.add(str);
        f(0, s, new ArrayList<>());
        return res;
    }

    static void f(int ind, String s, ArrayList<String> temp) {
        int n = s.length();
        StringBuilder str = new StringBuilder();

        if (ind >= n) {
            for (String i : temp)
                str.append(i + " ");

            res.add(str.toString());
            return;
        }

        for (int i = ind; i < n; i++) {
            str.append(s.charAt(i));

            if (dict.contains(str.toString())) {
                temp.add(new String(str.toString()));
                f(i + 1, s, temp);
                temp.remove(temp.size() - 1);
            }
        }

    }
}