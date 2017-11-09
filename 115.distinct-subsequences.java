class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) {
            return 0;
        }

        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();

        int [][] space = new int[sArr.length + 1][tArr.length + 1];

        for(int i = 0; i <= sArr.length; i++) {
            space[i][0] = 1;
        }

        for(int i = 1; i <= sArr.length; i++) {
            for(int j = 1; j <= tArr.length; j++) {
                if(sArr[i - 1] == tArr[j - 1]) {
                    space[i][j] = space[i - 1][j - 1] + space[i - 1][j];
                } else {
                    space[i][j] = space[i - 1][j];
                }
            }

        }

        return space[sArr.length][tArr.length];
    }
}
