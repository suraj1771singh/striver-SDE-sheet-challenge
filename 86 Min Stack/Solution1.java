import java.util.*;
import java.io.*;

class Solution {

    static class MinStack {

        Stack<int[]> st;
        int min;

        MinStack() {
            st = new Stack<>();
            min = (int) 1e9;

        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            st.push(new int[] { num, min });
            min = Math.min(min, num);

        }

        // Function to remove the top element of the stack.
        int pop() {
            if (st.isEmpty())
                return -1;
            int item[] = st.pop();
            if (min == item[0])
                min = item[1];
            return item[0];
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if (st.isEmpty())
                return -1;
            return st.peek()[0];
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if (st.isEmpty())
                return -1;
            return min;
        }
    }
}