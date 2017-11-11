class Solution {

    public int maxSubArray(int[] nums) {
        int start = 0, end = nums.length;

        return sumArray(nums, start, end - 1);
    }

    private int sumArray(int [] nums, int left, int right) {
        if(left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftSum = sumArray(nums, left, mid);
        int rightSum = sumArray(nums, mid + 1, right);
        int crossSum = crossingSum(nums, left, mid, right);

        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    private int crossingSum(int [] nums, int left, int mid, int right) {
        int lSum = 0, lMax = Integer.MIN_VALUE;
        for(int k = mid; k >= left; k--) {
            lSum += nums[k];
            lMax = Math.max(lMax, lSum);
        }

        int rSum = 0, rMax = Integer.MIN_VALUE;
        for(int k = mid + 1; k <= right; k++) {
            rSum += nums[k];
            rMax = Math.max(rMax, rSum);
        }

        return lMax + rMax;
    }
}

