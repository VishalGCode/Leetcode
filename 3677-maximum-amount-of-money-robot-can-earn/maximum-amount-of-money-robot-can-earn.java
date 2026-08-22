class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        int[][][] dp = new int[n][m][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = coins[0][0];
        if(coins[0][0] < 0) dp[0][0][1] = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 3; k++){
                    if(i == 0 && j == 0) continue;
                    int val = coins[i][j];
                    if(i > 0){
                        if(dp[i-1][j][k] != Integer.MIN_VALUE){
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k] + val);
                        } 
                        if(val < 0 && k > 0 && dp[i-1][j][k-1] != Integer.MIN_VALUE){
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k-1]);
                        }
                    }
                    if(j > 0){
                        if(dp[i][j-1][k] != Integer.MIN_VALUE){
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k] + val);
                        }
                        if(val < 0 && k > 0 && dp[i][j-1][k-1] != Integer.MIN_VALUE){
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k-1]);
                        }
                    }
                }
            }
        }
        return Math.max(dp[n-1][m-1][0], Math.max(dp[n-1][m-1][1], dp[n-1][m-1][2]));
    }
}