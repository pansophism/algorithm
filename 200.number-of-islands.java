
class Solution {

    public int numIslands(char[][] grid) {
        int count = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    count++;
                }

                populate(grid, r, c);
            }
        }

        return count;
    }

    private void populate(char [][] grid, int row, int col) {

        if(row < 0 || col < 0 ||
                row >= grid.length || col >= grid[0].length
                || grid[row][col] != '1') {
            return;
                }

        grid[row][col] = '-';
        populate(grid, row + 1, col);
        populate(grid, row - 1, col);
        populate(grid, row, col + 1);
        populate(grid, row, col - 1);
    }
}
