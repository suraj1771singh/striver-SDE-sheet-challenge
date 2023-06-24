import java.util.Stack;

class Solution {
    public static int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++)
            st.add(i);
        while (st.size() > 1) {
            int p1 = st.pop();
            int p2 = st.pop();
            boolean case1 = Runner.knows(p1, p2);
            boolean case2 = Runner.knows(p2, p1);
            if (case1 == case2)
                continue;
            else if (case1)
                st.add(p2);
            else
                st.add(p1);
        }
        if (st.isEmpty())
            return -1;
        int ans = st.peek();
        for (int i = 0; i < n; i++) {
            if (ans != i && (Runner.knows(ans, i) || !Runner.knows(i, ans)))
                return -1;
        }
        return ans;
    }
}
// Time complexity : O(n)