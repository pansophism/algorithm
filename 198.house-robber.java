class Solution {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
