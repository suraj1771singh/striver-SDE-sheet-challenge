import java.util.*;

//------------------SLIDING WINDOW
class Solution {
    public static int uniqueSubstrings(String input) {
        int s = 0, n = input.length(), ans = 0;
        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (set.contains(c)) {
                while (s < n && input.charAt(s) != c)
                    set.remove(input.charAt(s++));
                s++;
            } else
                set.add(c);

            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
// Time complexit : O(n)
