import java.util.*;

class Solution {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            q.add(new int[] { kArrays.get(i).get(0), i, 0 });
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int item[] = q.poll();
            res.add(item[0]);
            int nc = item[2] + 1;
            if (kArrays.get(item[1]).size() > nc)
                q.add(new int[] { kArrays.get(item[1]).get(nc), item[1], nc });
        }
        return res;

    }
}
