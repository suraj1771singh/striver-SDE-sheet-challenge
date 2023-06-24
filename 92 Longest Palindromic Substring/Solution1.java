import java.util.*;

class Solution {
    public static String longestPalinSubstring(String str) {
        int end = 0, start = 0, len = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            len = Math.max(expandFromCenter(str, i, i), expandFromCenter(str, i, i + 1));
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int expandFromCenter(String str, int i, int j) {
        int n = str.length();
        while (i >= 0 && j < n && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
