import java.util.*;

public class Solution {

    static int kthLargest(ArrayList<Integer> arr, int size, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : arr) {
            if (q.size() < K)
                q.add(num);
            else {
                if (q.peek() < num) {
                    q.poll();
                    q.add(num);
                }
            }
        }
        return q.peek();
    }
}
