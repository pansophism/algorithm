
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode [] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }

        if(start < end) {
            int mid = start + (end - start) / 2;

            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);

            return mergeTwoLists(l1, l2);
        }

        return null;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2 == null) return l1;
        if(l1 == null) return l2;

        if(l1.val < l2.val) {
            ListNode temp = l1;
            temp.next = mergeTwoLists(l1.next, l2);
            return temp;
        } else {
            ListNode temp = l2;
            temp.next = mergeTwoLists(l1, l2.next);
            return temp;
        }
    }
}
