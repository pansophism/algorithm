class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        if(((len1 + len2) % 2) == 1) {
            // if odd number, pick the mid
            return findKth(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2 + 1);
        } else {
            return
                // if even number, pick the average mid and mid + 1
                (findKth(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2) +
                 findKth(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2 + 1)) / 2;
        }
    }

    private double findKth(int [] nums1, int start1, int end1,
            int [] nums2, int start2, int end2,
            int k) {

        int len1 = end1 - start1;
        int len2 = end2 - start2;

        if(len1 <= 0) return nums2[start2 + k - 1];
        if(len2 <= 0) return nums1[start1 + k - 1];

        if(k <= 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = start1 + (end1 - start1) / 2;
        int mid2 = start2 + (end2 - start2) / 2;

        if(len1 / 2 + len2 / 2 + 1 >= k) { // k is on left side

            if(nums1[mid1] >= nums2[mid2]) { // nums1 is bigger, discard right side of nums1
                return findKth(nums1, start1, mid1, nums2, start2, end2, k);
            } else { // nums2 if bigger, discard right side of nums2
                return findKth(nums1, start1, end1, nums2, start2, mid2, k);
            }

        } else { // k is on right side

            if(nums1[mid1] >= nums2[mid2]) { // nums1 is bigger, discard left side of nums2
                return findKth(nums1, start1, end1, nums2, mid2 + 1, end2, k - (len2 / 2 + 1));
            } else { // nums2 if bigger, discard left side of nums1
                return findKth(nums1, mid1 + 1, end1, nums2, start2, end2, k - (len1 / 2 + 1));
            }
        }
    }

}


