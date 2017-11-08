class Solution {

    public int maxProfit(int k, int[] prices) {

        if(prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }

        int [][] space = new int[k + 1][prices.length];

        for(int i = 1; i <= k; i++) {

            int pMax = space[i - 1][0] - prices[0];
            for(int j = 1; j < prices.length; j++) {
                space[i][j] = Math.max(space[i][j - 1], pMax + prices[j]);
                pMax = Math.max(pMax, space[i][j - 1] - prices[j]);
            }
        }

        return space[k][prices.length - 1];

    }
}
