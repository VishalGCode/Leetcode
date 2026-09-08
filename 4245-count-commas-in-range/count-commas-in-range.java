class Solution {
    public int countCommas(int n) {
        if(n<=999) return 0;
        int count=0;
        for(int i=1000;i<=n;i++){
            if(i>=1000 && i<=100000) count++;
        }    
        return count;
    }
}