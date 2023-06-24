import java.util.*;

class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int res[] = new int[n];
        int left[] = new int[n]; // left range
        int right[] = new int[n]; // right range

        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Arrays.fill(res, -(int) 1e9);

        Stack<Integer> st = new Stack<>();
        // find just next smaller to left
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] > a[i])
                left[st.pop()] = i;
            st.add(i);
        }
        // find just next smaller to right
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] > a[i])
                right[st.pop()] = i;
            st.add(i);
        }

        // now keep track of max among same size of range
        for (int i = 0; i < n; i++) {
            int rangesize = right[i] - left[i] - 1;
            res[rangesize - 1] = Math.max(res[rangesize - 1], a[i]);
        }
        for (int i = n - 2; i >= 0; i--)
            res[i] = Math.max(res[i], res[i + 1]);

        return res;

    }
}
// Time complexity : O(n)
// Space complexity : O(n)
