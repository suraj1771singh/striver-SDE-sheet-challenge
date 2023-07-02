import java.util.*;

class Kthlargest {
    PriorityQueue<Integer> q;
    int limit;

    Kthlargest(int k, int[] arr) {
        q = new PriorityQueue<>();
        limit = k;
        for (int num : arr) {
            add(num);
        }
    }

    void add(int num) {
        if (q.size() < limit)
            q.add(num);
        else {
            if (q.peek() < num) {
                q.poll();
                q.add(num);
            }
        }
    }

    int getKthLargest() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }
}