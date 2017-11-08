class Solution {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }

        char [] sArr = s.toCharArray();
        char [] pArr = p.toCharArray();

        boolean [][] space = new boolean[sArr.length + 1][pArr.length + 1];
        space[0][0] = true;

        for(int i = 2; i <= pArr.length; i++) {
            if(pArr[i - 1] == '*') {
                space[0][i] = space[0][i - 2];
            }
        }

        for(int i = 1; i <= sArr.length; i++) {
            for(int j = 1; j <= pArr.length; j++) {
                if(sArr[i - 1] == pArr[j - 1]) {
                    space[i][j] = space[i - 1][j - 1];
                } else if(pArr[j - 1] == '*') {
                    if(sArr[i - 1] == pArr[j - 2] || pArr[j - 2] == '.') {
                        space[i][j] = space[i - 1][j] || space[i][j - 1] || space[i][j - 2];
                    } else {
                        space[i][j] = space[i][j - 2];
                    }
                }
            }
        }

        return space[sArr.length][pArr.length];

    }
}
