class Solution {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }

        char [] sArr = s.toCharArray();
        char [] pArr = p.toCharArray();

        boolean [][] dp = new boolean[sArr.length + 1][pArr.length + 1];
        dp[0][0] = true;

        for(int i = 2; i <= pArr.length; i++) {
            if(pArr[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for(int i = 1; i <= sArr.length; i++) {
            for(int j = 1; j <= pArr.length; j++) {
                if(sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if(pArr[j - 1] == '*') {
                        if(pArr[j - 2] == sArr[i - 1] || pArr[j - 2] == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
        }

        return dp[sArr.length][pArr.length];

    }
}
