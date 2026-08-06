class Solution {
    public int smallestNumber(int n, int t) {
    for(int i=n;i<101;i++){
        int pro=n;
        if(isDiv(pro,t)) return n;
        else n++;
    }    
    return -1;
    }
    private boolean isDiv(int n, int t){
        int pro=1;
        while(n>0){
            pro*=(n%10);
            n/=10;
        }
        return pro%t==0;
    }
}