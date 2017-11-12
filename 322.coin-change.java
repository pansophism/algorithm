class Solution {

    public int coinChange(int[] coins, int amount) {

        if(amount <= 0) {
            return 0;
        }

        int [] dp = new int[amount + 1];
        int sum = 1;

        while(sum <= amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }

            }
            dp[sum] = min;
            sum++;

        }
        return dp[amount];
    }
}

