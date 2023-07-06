
class Solution {

    public static int palindromePartitioning(String str) {
        int n = str.length();
        Integer dp[] = new Integer[n];
        return f(0, str, dp) - 1;
    }

    static int f(int ind, String str, Integer dp[]) {
        int n = str.length();
        if (ind >= n)
            return 0;
        if (dp[ind] != null)
            return dp[ind];
        int res = (int) 1e9;
        StringBuilder s = new StringBuilder();
        for (int i = ind; i < n; i++) {
            s.append(str.charAt(i));
            if (isPalindrome(s.toString())) {
                res = Math.min(res, 1 + f(i + 1, str, dp));
            }
        }
        return dp[ind] = res;
    }

    static boolean isPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
}
// Time complexity : O(n^3)
