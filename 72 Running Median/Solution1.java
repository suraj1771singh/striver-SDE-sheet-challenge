
import java.util.*;

class Solution {

    public static void findMedian(int arr[]) {

        PriorityQueue<Integer> q1 = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> q2 = new PriorityQueue<>((a, b) -> a - b);

        for (int num : arr) {
            if (q2.isEmpty())
                q2.add(num);
            else if (num <= q2.peek())
                q1.add(num);
            else
                q2.add(num);

            // balance both queue;
            while (Math.abs(q1.size() - q2.size()) > 1) {
                if (q1.size() > q2.size())
                    q2.add(q1.poll());
                else
                    q1.add(q2.poll());
            }

            int median = 0;
            if (q2.size() > q1.size())
                median = q2.peek();
            else if (q2.size() < q1.size())
                median = q1.peek();
            else
                median = (q1.peek() + q2.peek()) / 2;
            System.out.print(median + " ");
        }

    }

}