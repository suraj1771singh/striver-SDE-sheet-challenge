import java.util.ArrayList;

class Solution {
    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {
        int ans = 0;
        int cnt = 0;
        int prefix[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0)
                cnt++;
            prefix[i] = cnt;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int zeros = 0;
                if (j - 1 < 0)
                    zeros = prefix[i];
                else
                    zeros = prefix[i] - prefix[j - 1];
                if (zeros <= k)
                    ans = Math.max(i - j + 1, ans);
            }
        }
        return ans;
    }
}