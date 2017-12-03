class Solution {

    public int maxCoins(int[] iNums) {
        int [] newArray = new int[iNums.length + 2];
        newArray[0] = 1;
        newArray[newArray.length - 1] = 1;

        for(int i = 1; i <= iNums.length; i++) {
            newArray[i] = iNums[i - 1];
        }

        int [][] dp = new int[iNums.length + 2][iNums.length + 2];

        return burst(dp, newArray, 0, newArray.length - 1);
    }

    private int burst(int [][] dp, int [] nums, int left, int right) {
        if(left == right - 1) {
            return 0;
        }

        if(dp[left][right] > 0) {
            return dp[left][right];
        }

        int t = 0;

        for(int i = left + 1; i < right; i++) {
            t = Math.max(t, nums[left] * nums[i] * nums[right]
                    + burst(dp, nums, left, i)
                    + burst(dp, nums, i, right));
        }

        dp[left][right] = t;

        return t;
    }
}
