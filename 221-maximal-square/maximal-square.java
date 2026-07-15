class Solution {
    public int maximalSquare(char[][] matrix) {
    int r=matrix.length, c=matrix[0].length, mx=0;
    int[] curr = new int[c+1], next = new int[c+1];
    for(int i=r-1; i>=0; i--){
        for(int j=c-1; j>=0; j--){
            int right=curr[j+1], down=next[j], diagonal=next[j+1];
            if(matrix[i][j]=='1'){
                int store=Math.min(right, down);
                curr[j]=1+Math.min(store, diagonal);
                mx=Math.max(mx,curr[j]);
            }else curr[j]=0;
        }
        next=curr.clone();
    }
        return mx*mx;  
    }
}