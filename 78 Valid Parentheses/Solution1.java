import java.util.*;

class Solution {
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> st = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (st.isEmpty() || c == '{' || c == '(' || c == '[')
                st.add(c);
            else if (c == '}' && st.peek() == '{')
                st.pop();
            else if (c == ']' && st.peek() == '[')
                st.pop();
            else if (c == ')' && st.peek() == '(')
                st.pop();
            else
                st.push(c);
        }
        return st.size() == 0;
    }
}