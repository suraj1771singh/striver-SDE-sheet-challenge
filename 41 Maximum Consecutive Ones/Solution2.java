import java.util.ArrayList;

//--------Sliding window technique(Efficient Solution)
class Solution {
    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {
        int l = 0;
        int cnt_zero = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0)
                cnt_zero++;
            while (l < i && cnt_zero > k) {
                if (arr.get(l) == 0) {
                    cnt_zero--;
                }
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
// Time complexity : O(n)