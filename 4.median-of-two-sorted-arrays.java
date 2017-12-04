class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;

        int k = (l1 + l2) / 2;

        if((l1 + l2) % 2 == 1) {
            return findKth(nums1, 0, l1, nums2, 0, l2, k + 1);
        }

        return (findKth(nums1, 0, l1, nums2, 0, l2, k)
                + findKth(nums1, 0, l1, nums2, 0, l2, k + 1)) / 2;
    }

    private double findKth(
            int [] nums1, int lo1, int hi1,
            int [] nums2, int lo2, int hi2,
            int k) {

        int m1 = lo1 + (hi1 - lo1) / 2;
        int m2 = lo2 + (hi2 - lo2) / 2;

        if(lo1 >= hi1) return nums2[lo2 + k - 1];
        if(lo2 >= hi2) return nums1[lo1 + k - 1];

        if(k <= 1) return Math.min(nums1[lo1], nums2[lo2]);

        int len1 = hi1 - lo1;
        int len2 = hi2 - lo2;

        if(len1 / 2 + len2 / 2 + 1 >= k) {
            if(nums1[m1] >= nums2[m2]) {
                return findKth(nums1, lo1, m1, nums2, lo2, hi2, k);
            } else {
                return findKth(nums1, lo1, hi1, nums2, lo2, m2, k);
            }
        } else {
            if(nums1[m1] >= nums2[m2]) {
                return findKth(nums1, lo1, hi1, nums2, m2 + 1, hi2, k - (len2 / 2 + 1));
            } else {
                return findKth(nums1, m1 + 1, hi1, nums2, lo2, hi2, k - (len1 / 2 + 1));
            }
        }

    }
}
