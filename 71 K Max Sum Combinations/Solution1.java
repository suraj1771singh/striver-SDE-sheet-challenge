import java.util.*;

class Solution {
    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> i - j);
        ArrayList<Integer> res = new ArrayList<>();
        Collections.sort(a, (i, j) -> j - i);
        Collections.sort(b, (i, j) -> j - i);
        for (int p : a) {
            for (int q : b) {
                if (pq.size() < k)
                    pq.add(p + q);
                else {
                    int sum = p + q;
                    if (sum > pq.peek()) {
                        pq.poll();
                        pq.add(sum);
                    } else
                        break;
                }
            }
        }
        res.addAll(pq);
        Collections.sort(res, (i, j) -> j - i);
        return res;
    }
}