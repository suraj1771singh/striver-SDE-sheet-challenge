import java.util.*;

class Solution {
    public static int maximumProduct(ArrayList<Integer> arr, int n) {
        int pre = 1, suff = 1, ans = -(int) 1e9;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;
            pre *= arr.get(i);
            suff *= arr.get(n - 1 - i);
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}
// Time complexity : O(n)