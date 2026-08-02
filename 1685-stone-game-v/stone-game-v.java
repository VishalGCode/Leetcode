class Solution {
    public int stoneGameV(int[] stonevalue) {
    int n=stonevalue.length;
    int[][] dp=new int[n][n+1];
    int[] prefixsum=new int[n+1];
    for(int i=n-1;i>=0;i--){
        prefixsum[i]+=(prefixsum[i+1]+stonevalue[i]);
    }
    getmax(prefixsum,0,n,dp);
    return dp[0][n];
    }
    private int getmax(int[] psum, int lw, int h, int[][] dp){
        if(lw>=h-1) return 0;
        if(dp[lw][h]!=0) return dp[lw][h];
        int max=Integer.MIN_VALUE;
        for(int i=1;i+lw<h;i++){
            int r=psum[lw+i]-psum[h];
            int l=psum[lw]-psum[lw+i];
            if(r>l) max=Math.max(l+getmax(psum,lw,lw+i,dp),max); // this should discard the right position
            if(r<l) max=Math.max(r+getmax(psum,lw+i,h,dp),max); //this should discard the left position
            if(r==l){
                int lf=getmax(psum,lw,lw+i,dp)+r;
                int rg=getmax(psum,lw+i,h,dp)+l;
                max=Math.max(max,Math.max(rg,lf)); //alice will choose the maximum option when r get equal to lw
            }
        }
        return dp[lw][h]=max;
    }
}