public class Solution {
    public static Node rotate(Node head, int k) {

        int n = 0;
        Node h = head;
        while (h != null) {// count length of linkedlist
            n++;
            h = h.next;
        }
        if (k % n == 0)
            return head;

        k = n - k % n;
        Node newHead = head;

        while (k-- > 0)// initialise newhead pointer
            newHead = newHead.next;

        h = newHead;
        while (true) {

            if (h.next == null)
                h.next = head;

            h = h.next;
            if (h.next == newHead) {
                h.next = null;
                break;
            }
        }
        return newHead;

    }
}