class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int prod=1,sum=0;
        while(temp!=0){
            int d=temp%10;
            sum=sum+d;
            prod=prod*d;
            temp=temp/10;
        }
        int div=sum+prod;
        return n%div==0;
    }
}