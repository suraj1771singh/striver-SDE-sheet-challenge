import java.util.*;;

class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {
        List<Integer> temp = new ArrayList<>();
        int n = arr.length;
        temp.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (temp.get(temp.size() - 1) < arr[i])
                temp.add(arr[i]);
            else {
                int ind = binarSearch(arr[i], temp);
                temp.set(ind, arr[i]);
            }
        }
        return temp.size();
    }

    static int binarSearch(int x, List<Integer> a) {
        int l = 0, h = a.size() - 1;
        int res = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a.get(mid) < x) {
                l = mid + 1;

            } else {
                h = mid - 1;
                res = mid;
            }
        }
        return res;
    }

}
// Time complexity : O(n*logn)
// Space complexity : O(n)