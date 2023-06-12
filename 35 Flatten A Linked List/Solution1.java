public class Solution {
    public static Node flattenLinkedList(Node head) {
        Node prev = null;
        Node h = head;
        while (h != null) {
            Node next = h.next;
            Node curr = h;
            prev = merge(prev, curr);
            prev.next = null;// making next pointer to null
            curr.next = null;// making next pointer to null
            h = next;
        }
        return prev;

    }

    public static Node merge(Node prev, Node curr) {
        Node newhead = new Node(0);
        Node h = newhead;
        // prev.next=null;
        // curr.next=null;
        while (prev != null && curr != null) {
            if (prev.data < curr.data) {
                h.child = prev;
                h = h.child;
                prev = prev.child;
            } else {
                h.child = curr;
                h = h.child;
                curr = curr.child;
            }
        }
        if (prev != null)
            h.child = prev;
        else
            h.child = curr;

        return newhead.child;
    }

}
// Time complexity : o(n*n*m)
// Space complexity : O(1)
// n : number of head in list
// m : number of sublist
