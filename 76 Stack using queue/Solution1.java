import java.util.*;
import java.io.*;

class Stack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public Stack() {
        // Implement the Constructor.
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void push(int element) {
        q2.add(element);
        while (!q1.isEmpty())
            q2.add(q1.poll());
        q1.addAll(q2);
        q2.clear();
    }

    public int pop() {
        if (isEmpty())
            return -1;
        else
            return q1.poll();
    }

    public int top() {
        if (isEmpty())
            return -1;
        return q1.peek();
    }
}