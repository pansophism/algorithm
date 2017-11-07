class Solution {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }

        char [] sArr = s.toCharArray();
        char [] pArr = p.toCharArray();

        boolean [][] dp = new boolean[sArr.length + 1][pArr.length + 1];
        dp[0][0] = true;

        for(int i = 3; i < p.length(); i++) {
            if(pArr[i] == '*') {
                dp[i][0] = dp[i - 2][0];
            }
        }

        for(int i = 1; i <= sArr.length; i++) {
            for(int j = 1; j <= pArr.length; j++) {
                if(sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pArr[j - 1] == '*') {
                    if(sArr[i - 1] == pArr[j - 2] || pArr[j - 2] == '.') {
                        dp[i][j] = dp[i - 2][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[sArr.length][pArr.length];

    }
}
