class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] dp=new long[n+1];
        Arrays.fill(dp,Long.MAX_VALUE/2);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i){
            for(int j = Math.max(0, i - 3); j < i; ++j){
                long cost = dp[j] + costs[i - 1] + (long)(i - j) * (i - j);
                dp[i] = Math.min(dp[i], cost);
            }
        }
        return (int)dp[n];    
    }
}