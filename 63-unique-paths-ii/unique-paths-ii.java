class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int r=obstacleGrid.length, c=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[r-1][c-1]==1) return 0;
        int[][] dp = new int[r][c];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(obstacleGrid,r,c,0,0,dp);    
    }
    private int solve(int[][] grid,int r,int c,int i,int j,int[][] dp ){
        if(i>=r || i<0 || j>=c || j<0) return 0;
        if(i==r-1 && j==c-1) return 1;
        if(grid[i][j]==1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int right=solve(grid,r,c,i,j+1,dp);
        int down=solve(grid,r,c,i+1,j,dp);
        return dp[i][j]=right+down;
    }
}