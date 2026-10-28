class Solution{
    private int solve(int[]coins,int amount,int[]dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];
        int mn=Integer.MAX_VALUE;
        for(int coin:coins){
            int ans=solve(coins,amount-coin,dp);
            if(ans!=Integer.MAX_VALUE){
            mn=Math.min(mn,1+ans);
            }
        }
        dp[amount]=mn;
        return mn;
    }
    public int coinChange(int[]coins,int amount){
        int[]dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=solve(coins,amount,dp);
        return(ans==Integer.MAX_VALUE)?-1:ans;
    }
}