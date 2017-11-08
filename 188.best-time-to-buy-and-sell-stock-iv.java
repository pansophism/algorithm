class Solution {

    public int maxProfit(int k, int[] prices) {

        if(prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }

        if(k >= prices.length / 2) {
            int maxPro = 0;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]) {
                    maxPro += prices[i] - prices[i - 1];
                }
            }

            return maxPro;
        }

        int [][] space = new int[k + 1][prices.length];

        for(int i = 1; i <= k; i++) {

            // buy at the first day how much i would make / invest
            int pMax = 0 - prices[0];

            for(int j = 1; j < prices.length; j++) {
                space[i][j] = Math.max(space[i][j - 1], pMax + prices[j]);
                // what if I buy / invest today
                pMax = Math.max(pMax, space[i - 1][j] - prices[j]);
            }
        }

        return space[k][prices.length - 1];

    }
}
