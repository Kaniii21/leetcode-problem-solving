class Solution {
    public int matrixScore(int[][] grid) {
     int numRows = grid.length, numCols = grid[0].length;
        for (int row = 0; row < numRows; ++row) {
            if (grid[row][0] == 0) {
                for (int col = 0; col < numCols; ++col) {
                    grid[row][col] ^= 1; 
                }
            }
        }
        int ans = 0; 
        
        for (int col = 0; col < numCols; ++col) {
            int colCount = 0; 
            for (int row = 0; row < numRows; ++row){
                colCount += grid[row][col];
            }
    ans += Math.max(colCount, numRows - colCount) * (1 << (numCols - col - 1));
 }
     return ans;
    }
}    