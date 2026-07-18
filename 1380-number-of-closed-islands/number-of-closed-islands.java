class Solution {
    public int closedIsland(int[][] grid) {
    int r=grid.length, c=grid[0].length, count=0;
        for(int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if(grid[i][j]==0) if(solve(grid,i,j)) count++;
            }
        }
        return count;    
    }
    private boolean solve(int[][] grid, int r, int c){
        int row=grid.length, col=grid[0].length;
        if(r>=row || r<0 || c>=col || c<0) return false;
        if(grid[r][c]==1) return true;
        grid[r][c]=1;
        boolean up=solve(grid, r-1, c);
        boolean down=solve(grid, r+1, c);
        boolean right=solve(grid, r, c+1);
        boolean left=solve(grid, r, c-1);
        return up && down && right && left;
    }
}