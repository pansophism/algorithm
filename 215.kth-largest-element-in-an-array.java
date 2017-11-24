class Solution {

    public int findKthLargest(int[] a, int k) {
        return a[findKth(a, 0, a.length - 1, a.length - k + 1)];
    }

    private int findKth(int [] a, int lo, int hi, int k) {

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
            return findKth(a, lo, i - 1, k);
        } else {
            return findKth(a, i + 1, hi, k - m);
        }

    }

    private void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
