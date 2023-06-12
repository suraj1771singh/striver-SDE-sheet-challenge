//IDEA : reverse each block add each of their head to arr, 
//join them and finally add remaining node that are not reversed
public class Solution {
    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        List<Node> arr = new ArrayList<>();
        Node h = head;
        int ind = 0;
        Node newhead = null;
        while (ind < n && h != null) {
            if (b[ind]-- > 0) {
                Node next = h.next;
                h.next = newhead;
                newhead = h;
                h = next;
            } else {
                Node temp = newhead;
                arr.add(temp);
                newhead = null;
                ind++;
            }
        }

        arr.add(newhead);

        Node end = new Node(0);
        Node start = end;
        for (Node t : arr) {
            while (t != null) {
                end.next = t;
                end = end.next;
                t = t.next;
            }
        }
        // add remaining ones
        while (h != null) {
            end.next = h;
            end = end.next;
            h = h.next;
        }
        return start.next;
    }
}
// Time complexit : O(2*len)
// Space complexity : O(n)