
// -----------EFFICIENT

import java.util.*;

class Solution {

    public static int lengthOfLongestConsecutiveSequence(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i : arr)
            set.add(i);
        for (int num : arr) {
            if (set.contains(num - 1))
                continue;// if prev exist, then num cannot be starting point of any sequence
            int len = 0;
            while (set.contains(num++))
                len++;
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
// Time complexity : O(3n)