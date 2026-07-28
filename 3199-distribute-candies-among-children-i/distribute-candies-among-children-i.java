class Solution {
    public int distributeCandies(int n, int limit) {
    // if(limit>n) limit=0;
    int c=0;
    for(int i=0;i<=Math.min(limit,n);i++){
        for(int j=0;j<=Math.min(limit,n);j++){
            for(int k=0;k<=Math.min(limit,n);k++){
                if(i+j+k==n) c++;
            }
        }
    }
    return c;
    }
}