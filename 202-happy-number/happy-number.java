class Solution {
    public boolean isHappy(int n) {
    if(n==1) return true;
    if(n==4) return false;
    int num=square(n);
    return isHappy(num);    
    }
    public int square(int n){
        int s=0;
        while(n>0){
            int r=n%10;
            s=s+(r*r);
            n=n/10;
        }
        return s;
    }
}