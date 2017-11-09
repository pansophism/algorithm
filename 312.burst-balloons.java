class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int [][] dp = new int[nums.length][nums.length];

        for(int len = 1; len <= nums.length; len++) {
            for(int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;

                for(int i = start; i <= end; i++) {
                    int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                    coins += i != start ? dp[start][i - 1] : 0;
                    coins += i != end ? dp[i + 1][end] : 0;

                    dp[start][end] = Math.max(dp[start][end], coins);
                }

            }
        }

        return dp[0][nums.length - 1];
    }

    private int getValue(int [] nums, int index) {
        if(index < 0 || index >= nums.length) {
            return 1;
        }

        return nums[index];
    }
}
