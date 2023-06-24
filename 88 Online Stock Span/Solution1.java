
import java.util.*;

class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // decreasing monotonic stack
        Stack<Integer> st = new Stack<>();
        int n = price.size();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(i + 1);

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && price.get(st.peek()) < price.get(i)) {
                int ind = st.pop();
                res.set(ind, ind - i);
            }
            st.add(i);
        }
        return res;
    }
}