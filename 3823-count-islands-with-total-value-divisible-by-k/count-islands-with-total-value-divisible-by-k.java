class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long s=dfs(grid,m,n,i,j);
                    if(s%k==0) ans++;
                }
            }
        }
        return ans;
                
    }
    private long dfs(int[][] grid, int m, int n, int i, int j){
        if(i<0||i>=m||j<0||j>=n||grid[i][j]==0) return 0;
        long sum=grid[i][j];
        grid[i][j]=0;
        sum+=dfs(grid,m,n,i+1,j);
        sum+=dfs(grid,m,n,i-1,j);
        sum+=dfs(grid,m,n,i,j+1);
        sum+=dfs(grid,m,n,i,j-1);
        return sum;
    }
}