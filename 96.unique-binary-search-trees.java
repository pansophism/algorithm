class Solution {

    public int numTrees(int n) {

        int [] space = new int[n + 1];
        space[0] = 1;
        space[1] = 1;

        for(int i = 2; i <= n; i++) {
            space[i] = 0;
            for(int j = 1; j <= i; j++) {
                space[i] += (space[i - j] * space[j - 1]);
            }
        }

        return space[n];
    }
}
