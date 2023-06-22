import java.util.*;

class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            res.add(-1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr.get(st.peek()) > arr.get(i))
                res.set(st.pop(), arr.get(i));
            st.add(i);
        }
        return res;
    }
}