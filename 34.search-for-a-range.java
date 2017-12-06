class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        if(nums == null || nums.length < 1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int start = findLastSmaller(nums, target);
        int end = findLastSmaller(nums, target + 1);

        if(start == end) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        res[0] = start;
        res[1] = end;

        return res;
    }

    private int findLastSmaller(int [] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        if(target <= nums[lo]) {
            return lo - 1;
        }

        if(target > nums[hi]) {
            return hi;
        }

        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return lo;
    }
}
