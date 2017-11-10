class Solution {

    public int maxProfit(int k, int[] prices) {

        if(k <= 0 || prices == null || prices.length <= 1) {
            return 0;
        }

        int max = 0;
        int [][] dp = new int[k + 1][prices.length];

        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < prices.length; j++) {
                int temp = 0;
                for(int m = 0; m < j; m++) {
                    temp = Math.max(0, dp[i - 1][m] - prices[m] + prices[j]);
                }
                dp[i][j] = temp;
                max = Math.max(temp, max);
            }
        }

        return max;

    }
}
