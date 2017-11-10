class Solution {
    public int numDistinct(String s, String t) {

        if(s == null || t == null) {
            return 0;
        }

        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();

        int [][] dp = new int[sArr.length + 1][tArr.length + 1];

        for(int i = 0; i <= sArr.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= sArr.length; i++) {
            for(int j = 1; j <= tArr.length; j++) {
                if(sArr[i - 1] == tArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[sArr.length][tArr.length];
    }
}
