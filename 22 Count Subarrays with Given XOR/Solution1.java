import java.io.*;
import java.util.*;

class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int xor = 0, ans = 0;
        map.put(0, 1);
        for (int i : arr) {
            xor = xor ^ i;
            if (map.containsKey(xor ^ x))
                ans += map.get(xor ^ x);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return ans;
    }
}
// Time complexity : O(n)