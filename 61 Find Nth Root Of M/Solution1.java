class Solution {
    public static int NthRoot(int n, int m) {
        int l = 1, h = m;
        while (l <= h) {
            int mid = (l + h) / 2;
            int val = (int) Math.pow(mid, n);
            if (val == m)
                return mid;
            else if (val > m)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
