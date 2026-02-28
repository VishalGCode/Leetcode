class Solution {
    public int concatenatedBinary(int n) {
        final int MOD= 1000000007;
        long res=0, bits=0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0) bits++;
            res=((res<<bits)|i)%MOD;
        }    
        return (int)res;
    }
}