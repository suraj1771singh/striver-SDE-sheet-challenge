
class Solution {
    public static int findMajority(int[] arr, int n) {
        int candidate = findCandidate(arr, n);
        int freq = 0;
        for (int i : arr)
            if (i == candidate)
                freq++;
        if (freq > n / 2)
            return candidate;
        else
            return -1;

    }

    static int findCandidate(int a[], int n) {
        int vote = 1;
        int candidate = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] == candidate)
                vote++;
            else {
                vote--;
                if (vote == 0) {
                    vote = 1;
                    candidate = a[i];
                }

            }
        }
        return candidate;
    }
}
// Time complexity : O(n)