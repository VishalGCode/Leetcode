class Solution {
    public int distributeCandies(int n, int limit) {
    return (int)(ways(n)-3*ways(n-(limit+1))+3*ways(n-2*(limit+1))-ways(n-3*(limit+1)));
    }
    private long ways(int n){
        if(n<0) return 0;
        return (long)((n+1)*(n+2))/2;
    }
}