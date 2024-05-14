class Solution {
    private int maxGold = 0;
    public int getMaximumGold(int[][] grid) {
    int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }

        return maxGold;
    }

    private void dfs(int[][] grid, int row, int col, int currentGold) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        currentGold += grid[row][col];
        maxGold = Math.max(maxGold, currentGold);
        int temp = grid[row][col];
        grid[row][col] = 0;

        dfs(grid, row + 1, col, currentGold);
        dfs(grid, row - 1, col, currentGold);
        dfs(grid, row, col + 1, currentGold);
        dfs(grid, row, col - 1, currentGold);

        grid[row][col] = temp;
    }
}