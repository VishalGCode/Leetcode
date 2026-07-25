class Solution {
    public int smallestValue(int n) {
        while(true){
            int sum=primefactor(n);
            if(sum==n) return n;
            n=sum;
        }
    }
    private int primefactor(int n){
        int sum=0, factor=2;
        while(n>1){
            if(n%factor==0){
                sum+=factor;
                n/=factor;
            }else factor++;
        }
        return sum;
    }
}