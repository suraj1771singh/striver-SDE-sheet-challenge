class Solution {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        LinkedListNode<Integer> newhead = new LinkedListNode(0);
        LinkedListNode<Integer> a = first;
        LinkedListNode<Integer> b = second;
        LinkedListNode head = newhead;
        while (a != null && b != null) {
            if (a.data < b.data) {
                newhead.next = a;
                a = a.next;
            } else {
                newhead.next = b;
                b = b.next;
            }
            newhead = newhead.next;
        }
        while (a != null) {
            newhead.next = a;
            newhead = newhead.next;
            a = a.next;
        }
        while (b != null) {
            newhead.next = b;
            newhead = newhead.next;
            b = b.next;
        }
        return head.next;
    }

}