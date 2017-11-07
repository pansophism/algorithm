class Solution {

    public int numSquares(int n) {
        if(n <= 3) {
            return n;
        }

        int [] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {

            int temp = Integer.MAX_VALUE;

            for(int j = 1; j * j < i; j++) {
                temp = Math.min(temp, dp[i - j * j] + 1);
            }

            dp[i] = temp;
        }

        return dp[n];

    }
}
