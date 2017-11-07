class Solution {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int minSoFar = prices[0], max = 0;

        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return max;
    }
}
