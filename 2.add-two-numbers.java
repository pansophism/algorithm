/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode pointer = newHead;

        int carry = 0;

        while(l1 != null && l2 != null) {
            int v = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;

            if(v >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode temp = new ListNode(v >= 10 ? v - 10 : v);
            pointer.next = temp;
            pointer = pointer.next;
        }

        while(l1 != null) {
            int v = l1.val + carry;
            l1 = l1.next;
            if(v >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode temp = new ListNode(v >= 10 ? v - 10 : v);
            pointer.next = temp;
            pointer = pointer.next;
        }

        while(l2 != null) {
            int v = l2.val + carry;
            l2 = l2.next;

            if(v >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode temp = new ListNode(v >= 10 ? v - 10 : v);
            pointer.next = temp;
            pointer = pointer.next;
        }

        if(carry == 1) {
            ListNode temp = new ListNode(1);
            pointer.next = temp;
        }

        return newHead.next;
    }
}
