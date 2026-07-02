class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        int[][] d=new int[m][n];
        for(int[] r: d){
            Arrays.fill(r, Integer.MAX_VALUE);
        }    
        Deque<int[]> dq=new ArrayDeque<>();
        d[0][0] = grid.get(0).get(0);
        dq.offerFirst(new int[]{0,0});
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!dq.isEmpty()){
            int[] curr=dq.pollFirst();
            int x=curr[0];
            int y=curr[1];
            if(x==m-1 && y==n-1) return d[x][y] < health;
            for(int k=0; k<4; k++){
                int nx=x+dx[k];
                int ny=y+dy[k];
                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                int w=grid.get(nx).get(ny);
                if(d[x][y] + w < d[nx][ny]){
                    d[nx][ny] = d[x][y]+w;
                    if(w==0) dq.offerFirst(new int[]{nx, ny});
                    else dq.offerLast(new int[]{nx,ny});
                }
            }
        }
        return d[m-1][n-1]<health;
    }
}