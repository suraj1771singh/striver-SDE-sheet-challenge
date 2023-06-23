import java.util.*;

class Solution {

    public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums.get(q.peekLast()) <= nums.get(i))
                q.pollLast();
            q.add(i);
            while (!q.isEmpty() && q.peekFirst() <= i - k)
                q.pollFirst();
            if (i >= k - 1)
                res.add(nums.get(q.peekFirst()));

        }
        return res;
    }
}
// Time complexity : O(n)