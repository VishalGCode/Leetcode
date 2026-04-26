class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;   
        boolean visited[][] = new boolean[n][m];  
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!visited[row][col] && dfs(row, col, -1, -1, grid, visited, grid[row][col])){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int row, int col, int pr, int pc, char[][] grid, boolean visited[][], char ch) {
        if (visited[row][col]) return true;
        visited[row][col] = true;
        int n = grid.length, m = grid[0].length;    
        int directions[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int dir[] : directions) {
            int nrow = row + dir[0], ncol = col + dir[1]; 
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == ch) {
                if (nrow == pr && ncol == pc) continue;
                if (dfs(nrow, ncol, row, col, grid, visited, ch)) return true;
            }
        }
        return false;
    }
}