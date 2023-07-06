import java.util.*;

class Solution {
    static Set<String> set;

    public static Boolean wordBreak(String[] arr, int n, String target) {
        set = new HashSet<>();
        for (String s : arr)
            set.add(s);
        int m = target.length();
        Boolean dp[] = new Boolean[m];
        return f(0, target, dp);
    }

    static boolean f(int ind, String target, Boolean dp[]) {
        if (ind >= target.length())
            return true;
        if (dp[ind] != null)
            return dp[ind];
        StringBuilder str = new StringBuilder();
        for (int i = ind; i < target.length(); i++) {
            str.append(target.charAt(i));
            if (set.contains(str.toString())) {
                if (f(i + 1, target, dp))
                    return dp[ind] = true;
            }
        }
        return dp[ind] = false;
    }
}
// Time complexity : O(m^2)