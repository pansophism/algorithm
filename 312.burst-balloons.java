class Solution {

    public int maxCoins(int[] iNums) {

        int [] newArray = new int[iNums.length + 2];
        newArray[0] = 1;
        newArray[newArray.length - 1] = 1;

        for(int i = 0; i < iNums.length; i++) {
            newArray[i + 1] = iNums[i];
        }

        int [][] dp = new int[newArray.length + 1][newArray.length + 1];

        return burst(dp, newArray, 0, newArray.length - 1);
    }

    private int burst(int [][] dp, int [] arr, int left, int right) {
        if(left == right - 1) {
            return 0;
        }

        if(dp[left][right] > 0) {
            return dp[left][right];
        }

        int ans = 0;
        for(int i = left + 1; i < right; i++) {
            ans = Math.max(ans, arr[left] * arr[i] * arr[right]
                    + burst(dp, arr, left, i)
                    + burst(dp, arr, i, right));
        }

        dp[left][right] = ans;

        return ans;
    }
}
