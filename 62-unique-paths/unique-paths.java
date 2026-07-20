class Solution {
    public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for(int[] row:dp) Arrays.fill(row,-1);
    return solve(m,n,0,0,dp);     
    }
    private int solve(int r, int c, int i, int j, int[][] dp){
        if(i<0 || i>=r || j<0 || j>=c) return 0;
        if(i==r-1 && j==c-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=solve(r,c,i,j+1,dp)+solve(r,c,i+1,j,dp);
    }
}