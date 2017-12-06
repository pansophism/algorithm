class Solution {
    public int searchInsert(int[] nums, int target) {

        int lo = 0, hi = nums.length - 1;

        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }
}
