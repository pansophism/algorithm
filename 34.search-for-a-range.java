class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        if(nums == null || nums.length < 1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int start = findFirstGreater(nums, target);
        if(start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        return new int[] {start, findFirstGreater(nums, target + 1) - 1};
    }

    private int findFirstGreater(int [] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while(lo + 1 < hi) {

            int mid = lo + (hi - lo) / 2;

            if(nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return hi;
    }
}
