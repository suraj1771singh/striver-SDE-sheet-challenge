import java.util.*;
import java.io.*;

class Solution {

    public static int[] nextGreater(int[] arr, int n) {
        int res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i])
                res[st.pop()] = arr[i];
            st.add(i);
        }
        return res;

    }

}
