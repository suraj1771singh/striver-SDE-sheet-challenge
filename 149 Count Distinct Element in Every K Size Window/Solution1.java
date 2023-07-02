import java.util.*;

public class Solution {

    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (i - k >= 0) {
                int cnt = map.get(arr.get(i - k));
                if (cnt == 1)
                    map.remove(arr.get(i - k));
                else
                    map.put(arr.get(i - k), cnt - 1);

            }
            if (i >= k - 1)
                res.add(map.size());
        }

        return res;
    }
}