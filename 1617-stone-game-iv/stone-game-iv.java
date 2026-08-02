class Solution {
    static Boolean[] dp;
    public boolean winnerSquareGame(int n) {
        dp=new Boolean[n+1];
        return solve(n);
    }
    public static boolean solve(int num){
        if(num==0) return false;
        if(dp[num] != null) return dp[num];
        for(int i=1;i*i<=num;i++){
            int s=i*i;
            // if((num=s)==0) return dp[num]=true;
            // if(num-s<0) return dp[num]=false;
            if(!solve(num-s)) return dp[num]=true;
        }
        return dp[num]=false;
    }
}