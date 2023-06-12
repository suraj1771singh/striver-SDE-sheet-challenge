public class Solution {
    public static Node firstNode(Node head) {
        Node sp = head;
        Node fp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                sp = head;
                while (sp != fp) {
                    sp = sp.next;
                    fp = fp.next;
                }
                return fp;
            }
        }
        return null;
    }
}
// Time complexity :O(n)