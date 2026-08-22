class Solution {
    public boolean checkDivisibility(int n) {
    int temp=n, sum=0, prod=1;
    while(temp!=0){
        int d=temp%10;
        sum+=d;
        prod*=d;
        temp/=10;  
    }   
    return n%(sum+prod)==0; 
    }
}