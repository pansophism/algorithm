class Solution {

    public int numTrees(int n) {

        int [] space = new int[n + 1];
        space[0] = 1;
        space[1] = 1;

        for(int i = 2; i <= n; i++) {
            space[i] = 0;
            for(int j = 1; j <= i; j++) {
                System.out.println("i : " + i + " || i - j = " + (i - j) + " || j - 1 = " + (j - 1));
                space[i] += (space[i - j] * space[j - 1]);
            }
        }

        return space[n];
    }
    public static void main(String [] args) {
        Solution s = new Solution();
        s.numTrees(5);
    }
}
