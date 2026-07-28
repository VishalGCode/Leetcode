class Solution {
    public long distributeCandies(int n, int limit) {
    return ways(n)-3*ways(n-(limit+1))+3*ways(n-2*(limit+1))-ways(n-3*(limit+1));
    }
    private long ways(long n){
        if(n<0) return 0;
        return ((n+1)*(n+2))/2;    
    }
}