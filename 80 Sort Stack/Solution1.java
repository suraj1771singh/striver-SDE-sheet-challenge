import java.util.*;

import java.io.*;

class Solution {

    public static void doSorting(Stack<Integer> stack, int x) {

        if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < x)) {
            stack.push(x);
            return;

        }
        int num = stack.peek();
        stack.pop();
        doSorting(stack, x);
        stack.push(num);

    }

    public static void sortStack(Stack<Integer> stack) {

        if (stack.isEmpty())
            return;
        int num = stack.peek();
        stack.pop();

        // recursive
        sortStack(stack);
        doSorting(stack, num);

    }

}