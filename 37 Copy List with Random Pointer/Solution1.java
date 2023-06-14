public class Solution {
    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
        if (head == null)
            return null;
        LinkedListNode<Integer> dummy = new LinkedListNode(0);
        LinkedListNode<Integer> h = head;
        while (h != null) {
            LinkedListNode<Integer> next = h.next;
            LinkedListNode<Integer> temp = new LinkedListNode(h.data);
            temp.next = next;
            h.next = temp;
            h = next;
        }
        // create random pointer
        dummy = head.next;
        h = head;
        LinkedListNode<Integer> d = dummy;
        while (h != null) {
            if (h.random != null)
                d.random = h.random.next;
            if (d.next == null)
                break;
            h = h.next.next;
            d = d.next.next;
        }
        // decoupling
        h = head;
        d = dummy;
        while (d != null) {
            h.next = d.next;
            h = h.next;
            if (h == null)
                break;
            d.next = h.next;
            d = d.next;

        }

        return dummy;
    }
}