class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return;
        } 
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                board[i][0]='V';
                q.offer(new int[]{i,0});
            }
            if(board[i][n-1]=='O'){
                board[i][n-1]='V';
                q.offer(new int[]{i,n-1});
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                board[0][j]='V';
                q.offer(new int[]{0,j});
            }
            if(board[m-1][j]=='O'){
                board[m-1][j]='V';
                q.offer(new int[]{m-1,j});
            }
        }
        int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O'){
                    board[nr][nc] = 'V';
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='V') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
}