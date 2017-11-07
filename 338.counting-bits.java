class Solution {
    public int[] countBits(int num) {

        int [] dp = new int[num + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= num; i++) {
            dp[i] = dp[i / 2] + (i & 1);
        }

        return dp;

    }
}
