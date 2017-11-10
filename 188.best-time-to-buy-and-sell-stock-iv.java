class Solution {

    public int maxProfit(int k, int[] prices) {

        if(k <= 0 || prices == null || prices.length <= 1) {
            return 0;
        }

        if(k >= prices.length / 2) {
            int maxPro = 0;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]) {
                    maxPro += (prices[i] - prices[i - 1]);
                }
            }

            return maxPro;
        }

        int [][] dp = new int[k + 1][prices.length];

        for(int i = 1; i <= k; i++) {
            int pMax = 0 - prices[0];
            for(int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], pMax + prices[j]);
                pMax = Math.max(pMax, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][prices.length - 1];

    }
}
