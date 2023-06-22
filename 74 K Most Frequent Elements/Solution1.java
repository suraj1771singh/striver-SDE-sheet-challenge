import java.util.*;

class Solution {

    public static int[] KMostFrequent(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> bucket[] = new ArrayList[n + 1];
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null)
                bucket[val] = new ArrayList<>();
            bucket[val].add(key);
        }
        int[] res = new int[k];
        int ind = 0;
        for (int i = n; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    res[ind++] = j;
                    if (ind == k)
                        return res;
                }
            }
        }
        return res;
    }

}