class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        return 0 - dfs(M, 0, 0, 0);
    }

    private int dfs(int [][] nums, int count, int row, int col) {

        for(int r = row; r < nums.length; r++) {
            for(int c = col; c < nums[0].length; c++) {
                if(nums[r][c] == 1) {
                    nums[r][c] = count;
                    dfs(nums, count, r, c);
                }
            }

            count--;
        }

        return count + 1;
    }
}
