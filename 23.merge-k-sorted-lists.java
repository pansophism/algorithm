
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int lo, int hi) {
        if(lo == hi) {
            return lists[lo];
        }

        if(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            ListNode l1 = partition(lists, lo, mid);
            ListNode l2 = partition(lists, mid + 1, hi);

            return merge(l1, l2);
        }

        // this should never happen
        return null;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val > l2.val) {
            ListNode temp = new ListNode(l2.val);
            temp.next = merge(l1, l2.next);
            return temp;
        } else {
            ListNode temp = new ListNode(l1.val);
            temp.next = merge(l1.next, l2);
            return temp;
        }
    }
}
