import java.io.*;
import java.util.*;

class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int n) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr)
            set.add(i);

        int ans = 0;
        int len = 1;
        int prev = (int) 1e9;
        for (int curr : set) {
            if (prev != (int) 1e9 && prev + 1 == curr)
                len++;
            else
                len = 1;
            prev = curr;
            ans = Math.max(ans, len);

        }
        return ans;
    }
}

// Time complexity : O(n*logn)