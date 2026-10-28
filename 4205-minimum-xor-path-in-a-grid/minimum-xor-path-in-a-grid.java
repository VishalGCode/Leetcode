class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][][] dp=new boolean[m+1][n+1][1024];
        solve(grid,m-1,n-1,grid[m-1][n-1],dp);
        for(int i=0;i<1024;i++){
            if(dp[0][0][i]) return i;
        }
        return 0;
    }
    public void solve(int[][] grid, int m, int n, int xor, boolean[][][]dp){
        if(m<0 || n<0) return;
        if(dp[m][n][xor]) return;
        dp[m][n][xor]=true;
        int left=(int) 1e9;
        int right=(int) 1e9;
        if(n-1>-1) solve(grid,m,n-1,xor^grid[m][n-1],dp);
        if(m-1>-1) solve(grid,m-1,n,xor^grid[m-1][n],dp);
    }
}  