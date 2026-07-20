class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k %= total;
        int[][] shifted = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int idx = i * n + j;
                int newIdx = (idx + k) % total;
                int rewRow = newIdx / n;
                int newCol = newIdx % n;
                shifted[rewRow][newCol] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < n; j++){
                row.add(shifted[i][j]);
            }
            res.add(row);
        }
        return res;
    }
}