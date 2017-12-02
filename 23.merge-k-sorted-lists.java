
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        return split(lists, 0, lists.length - 1);
    }

    private ListNode split(ListNode [] lists, int lo, int hi) {
        if(lo == hi) {
            return lists[lo];
        } else if(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            ListNode l1 = split(lists, lo, mid);
            ListNode l2 = split(lists, mid + 1, hi);

            return merge(l1, l2);
        }

        return null;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            ListNode temp = l1;
            temp.next = merge(l1.next, l2);
            return temp;
        } else {
            ListNode temp = l2;
            temp.next = merge(l1, l2.next);
            return temp;
        }
    }
}
