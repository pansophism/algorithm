class Solution {

    public int maxProfit(int k, int[] prices) {

        if(k <= 0 || prices == null || prices.length <= 1) {
            return 0;
        }

        int [][] dp = new int[k + 1][prices.length];

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j < prices.length; j++) {
                int temp = 0;
                for(int m = 0; m < j; m++) {
                    temp = Math.max(dp[i][j - 1], dp[i - 1][m] - prices[m] + prices[j]);
                }
                dp[i][j] = temp;
            }
        }

        return dp[k][prices.length - 1];

    }
}
