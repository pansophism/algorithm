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
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int carry = 0;
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;

        while(l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = (a + b + carry) % 10;

            carry = (a + b + carry) / 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        if(carry == 1) {
            cur.next = new ListNode(1);
        }

        return newHead.next;
    }
}
