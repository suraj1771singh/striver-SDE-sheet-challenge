class Solution {

    public static boolean detectCycle(Node head) {
        Node sp = head;
        Node fp = head;
        while (true) {
            if (fp == null || fp.next == null)
                return false;
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp)
                return true;
        }
    }
}