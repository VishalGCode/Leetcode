class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n);  
    }
    public int rec(int n){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int remaining=n-i*i;
            int count=1+rec(remaining);
            min=Math.min(min, count);
        }
        return dp[n]=min;
    }
}