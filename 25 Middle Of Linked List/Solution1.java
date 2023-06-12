class Solution {
    public static Node findMiddle(Node head) {
        Node fp = head, sp = head;
        Node h = head;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
        }
        return sp;
    }
}