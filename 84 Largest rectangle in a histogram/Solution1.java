import java.util.*;

class Solution {
    public static int largestRectangle(ArrayList<Integer> heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.size();
        int left[] = new int[n];
        int right[] = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights.get(st.peek()) > heights.get(i))
                left[st.pop()] = i;
            st.add(i);
        }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights.get(st.peek()) > heights.get(i))
                right[st.pop()] = i;
            st.add(i);
        }

        int maxarea = 0;
        for (int i = 0; i < n; i++) {
            int area = heights.get(i) * (right[i] - left[i] - 1);
            maxarea = Math.max(area, maxarea);
        }
        return maxarea;

    }
}
// Time complexity : O(n)
// Space complexity : O(n)