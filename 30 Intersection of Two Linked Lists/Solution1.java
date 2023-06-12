public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        Node l1 = firstHead;
        Node l2 = secondHead;
        while (true) {
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == l2)
                break;
            if (l1 == null)
                l1 = secondHead;
            if (l2 == null)
                l2 = firstHead;
        }
        if (l1 != null)
            return l1.data;
        else
            return -1;

    }
}
// Time complexity :O(2*(n+m))