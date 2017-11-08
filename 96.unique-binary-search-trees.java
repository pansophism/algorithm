class Solution {

    public int numTrees(int n) {
        if(n <= 3) {
            return n;
        }

        int [] space = new int[n + 1];
        space[0] = 0;
        space[1] = 1;

        for(int i = 2; i <= n; i++) {
            int sum = 0;

            for(int j = 1; j < i; j++) {
                sum += space[j] * space[i - j];
            }

            space[i] = sum;

        }

        return space[n];
    }
}
