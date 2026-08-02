class Solution {
    public boolean stoneGame(int[] piles) {
    int n=piles.length;
    int[][] dp = new int[n+1][n+1];
    return solve(piles,0,n-1,dp)>0;
    }
    private int solve(int[] piles, int st, int end, int[][] dp){
    if(st==end) return piles[st];
    if(dp[st][end] != 0) return dp[st][end];
    int left=piles[st]-solve(piles,st+1,end,dp);
    int right=piles[end]-solve(piles,st,end-1,dp);
    return dp[st][end]=Math.max(left,right);
    }
}