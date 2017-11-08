class Solution {

    public int numSquares(int n) {
        if(n <= 3) {
            return n;
        }

        int [] space = new int[n + 1];
        space[0] = 0;
        space[1] = 1;

        for(int i = 2; i <= n; i++) {

            int temp = Integer.MAX_VALUE;

            for(int j = 1; j * j <= i; j++) {
                temp = Math.min(temp, space[i - j * j] + 1);
            }

            space[i] = temp;
        }

        return space[n];

    }
}
