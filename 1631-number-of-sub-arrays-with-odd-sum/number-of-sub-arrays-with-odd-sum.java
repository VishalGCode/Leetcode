class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        long odd=0, even=1;
        long curr=0, total=0;
        for(int num:arr){
            curr+=num;
            if(curr%2==1){
                total=(total+even)%mod;
                odd++;
            }else{
                total=(total+odd)%mod;
                even++;
            }
        }
        return (int) total;
    }
}