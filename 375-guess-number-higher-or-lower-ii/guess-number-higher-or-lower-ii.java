class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        return solve(1,n,dp);
    }

    private int solve(int st, int end, int[][] dp){
        if(st>=end) return 0;
        if(dp[st][end]!=0) return dp[st][end];
        int ans=Integer.MAX_VALUE;
        for(int i=st;i<=end;i++){
            ans=Math.min(ans, i+Math.max(solve(st,i-1,dp), solve(i+1,end,dp)));
        }
        dp[st][end]=ans;
        return ans;
    }
}