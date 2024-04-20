class Solution {
    public int[][] findFarmland(int[][] land) {
    int m = land.length;
        int n = land[0].length;
        List<int[]> result = new ArrayList<>();
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int rowEnd = i;
                    int colEnd = j;
                    while (rowEnd < m && land[rowEnd][j] == 1) {
                        rowEnd++;
                    }
                    while (colEnd < n && land[i][colEnd] == 1) {
                        colEnd++;
                    }
                    result.add(new int[]{i, j, rowEnd - 1, colEnd - 1});
                    for (int r = i; r < rowEnd; r++) {
                        for (int c = j; c < colEnd; c++) {
                            land[r][c] = 0;
                        }
                    }
                }
            }
        }
        int[][] output = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }
}