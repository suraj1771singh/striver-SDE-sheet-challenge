import java.util.*;

class Queue {
    // Define the data members(if any) here.
    Stack<Integer> st;

    Queue() {
        // Initialize your data structure here.
        st = new Stack<>();
    }

    void enQueue(int val) {
        if (isEmpty()) {
            st.push(val);
            return;
        }
        int item = st.pop();
        enQueue(val);
        st.push(item);
    }

    int deQueue() {
        if (isEmpty())
            return -1;
        return st.pop();
    }

    int peek() {
        if (isEmpty())
            return -1;
        return st.peek();
    }

    boolean isEmpty() {
        return st.isEmpty();
    }
}