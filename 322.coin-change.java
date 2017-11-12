class Solution {

    public int coinChange(int[] coins, int amount) {

        if(amount <= 0) {
            return 0;
        }

        int [] dp = new int[amount + 1];
        dp[0] = 0;

        for(int sum = 1; sum < dp.length; sum++) {
            int min = -1;
            for(int coin : coins) {
                if((sum - coin) >= 0 && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }

            }

            dp[sum] = min;
        }

        return dp[amount];
    }
}

