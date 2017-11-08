class Solution {

    public int numSquares(int n) {
        if(n <= 3) {
            return n;
        }

        int [] space = new int[n + 1];
        space[0] = 0;
        space[1] = 1;
        space[2] = 2;
        space[3] = 3;

        for(int i = 4; i <= n; i++) {

            int t = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                t = Math.min(t, space[i - j * j] + 1);
            }

            space[i] = t;
        }

        return space[n];


    }
}
