class Solution {

    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int min = nums[0], max = nums[0], r = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            r = Math.max(max, r);
        }

        return r;
    }
}
