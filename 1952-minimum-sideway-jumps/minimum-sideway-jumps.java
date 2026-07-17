class Solution {
    public int minSideJumps(int[] obstacles) {
        int[][] dp= new int[4][obstacles.length];
        return solve(obstacles,2,0,dp);   
    }
    private int solve(int[] obs, int lane, int pos, int[][]dp){
        if(pos==obs.length-1) return 0;
        if(dp[lane][pos] != 0) return dp[lane][pos];
        if(obs[pos+1] != lane) return solve(obs,lane,pos+1,dp);
        else{
            int ans=Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(lane != i && obs[pos]!=i){
                    ans=Math.min(ans,1+solve(obs,i,pos,dp));
                }
            }
            return dp[lane][pos]=ans;
        }
    }
}