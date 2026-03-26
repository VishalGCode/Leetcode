class Solution {
    int[][] memo;
    public int numTrees(int n) {
       memo=new int[n+2][n+2]; 
       return count(1,n);
    }
    private int count(int start,int end){
        if(start>end) return 1;
        if(memo[start][end]!=0) return memo[start][end];
        int ans=0;
        for(int i=start;i<=end;i++){
            int left=count(start,i-1),right=count(i+1,end);
            ans+=left*right;
        }
        memo[start][end]=ans;
        return ans;
    }
}