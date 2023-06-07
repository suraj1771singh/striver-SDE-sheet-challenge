
//---------------KADANE'S THEOREM
class Solution {

    public static long maxSubarraySum(int[] arr, int n) {
        long dp[] = new long[n];
        dp[0] = Math.max(0, arr[0]);
        long max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
