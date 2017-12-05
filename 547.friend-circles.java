
class Solution {

    public int findCircleNum(int[][] M) {

        int [] visited = new int[M.length];
        int count = 0;

        for(int i = 0; i < M.length; i++) {
            if(visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int [][] nums, int[] visited, int i) {
        for(int j = 0; j < nums.length; j++) {
            if(nums[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(nums, visited, j);
            }
        }

    }

}
