class Solution {
    public long countCommas(long n) {
        long commas=0;
        for(long x=1000; x<=n; x*=1000) commas+=(n-x+1);
        return commas; 
    }
}