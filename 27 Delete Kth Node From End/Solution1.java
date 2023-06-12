class Solution {
    public static Node removeKthNode(Node head, int K) {
        Node p1 = head;
        Node p2 = head;
        while (K-- > 0 && p2 != null)
            p2 = p2.next;
        if (p2 == null)
            return head.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        Node next = p1.next;
        p1.next = next.next;
        return head;
    }
}
// Time complexity : O(n)