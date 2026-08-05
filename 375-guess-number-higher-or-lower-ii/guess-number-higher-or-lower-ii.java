class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int len=2;len<=n;len++){
            for(int i=1;i<=n-len+1;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int x=i;x<=j;x++){
                    int left=(x>i)?dp[i][x-1]:0, right=(x<j)?dp[x+1][j]:0;
                    int cost=x+Math.max(left,right);
                    dp[i][j]=Math.min(dp[i][j],cost);
                }
            }
        }
        return dp[1][n];
    }
}