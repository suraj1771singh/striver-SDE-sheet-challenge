import java.util.*;
import java.io.*;

/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * 
 * 
 *****************************************************************/

class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}

class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode h1 = head1;
        LinkedListNode h2 = head2;
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode head = dummy;
        int carry = 0, sum = 0;
        while (h1 != null && h2 != null) {
            sum = carry + h1.data + h2.data;
            carry /= 10;
            dummy.next = new LinkedListNode(sum % 10);
            dummy = dummy.next;
            h1 = h1.next;
            h2 = h2.next;
        }
        while (h1 != null) {
            sum = h1.data + carry;
            carry = sum / 10;
            dummy.next = new LinkedListNode(sum % 10);
            dummy = dummy.next;
            h1 = h1.next;
        }
        while (h2 != null) {
            sum = h2.data + carry;
            carry = sum / 10;
            dummy.next = new LinkedListNode(sum % 10);
            dummy = dummy.next;

            h2 = h2.next;
        }
        if (carry == 1)
            dummy.next = new LinkedListNode(1);
        return head;
    }
}