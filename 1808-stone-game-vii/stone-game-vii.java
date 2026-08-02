class Solution {
    public int stoneGameVII(int[] stones) {
    int[] prefix=new int[stones.length+1];
    for(int i=0;i<stones.length;i++){
        prefix[i+1]=prefix[i]+stones[i];
    }    
    int[][] dp=new int[stones.length][stones.length];
    for(int i=0;i<stones.length;i++){
        Arrays.fill(dp[i],-1);
    }
    return solve(stones,prefix,0,stones.length-1,dp);
    }
    private int solve(int[] stones, int[] prefix, int left,int right,int[][] dp){
        if(left==right) return 0;
        if(dp[left][right]!=-1) return dp[left][right];
        int n1=prefix[right+1]-prefix[left+1]-solve(stones,prefix,left+1,right,dp);
        int n2=prefix[right]-prefix[left]-solve(stones,prefix,left,right-1,dp);
        return dp[left][right]=Math.max(n1,n2);
    }
}