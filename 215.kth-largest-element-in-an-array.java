class Solution {

    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        int p = findKthLargest(a, 0, n - 1, n - k + 1);
        return a[p];

    }

    private void swap(int [] a, int from, int to) {
        int t = a[from];
        a[from] = a[to];
        a[to] = t;
    }

    private int findKthLargest(int [] a, int lo, int hi, int k) {

        int i = lo, j = hi, pivot = a[hi];

        while(i < j) {
            if(a[i++] > pivot) {
                swap(a, --i, --j);
            }
        }

        swap(a, i, hi);

        int m = i - lo + 1;

        if(m == k) {
            return i;
        } else if(m > k) {
            return findKthLargest(a, lo, i - 1, k);
        } else {
            return findKthLargest(a, i + 1, hi, k - m);
        }
    }
}

