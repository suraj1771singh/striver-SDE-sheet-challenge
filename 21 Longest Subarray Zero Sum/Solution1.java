
import java.util.*;

import java.util.ArrayList;

class Solution {

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0, sum = 0, n = arr.size();
        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            sum += num;
            if (map.containsKey(sum)) {
                int ind = map.get(sum);
                ans = Math.max(ans, i - ind);
            } else
                map.put(sum, i);
        }
        return ans;
    }
}
// Time complexity : O(n)