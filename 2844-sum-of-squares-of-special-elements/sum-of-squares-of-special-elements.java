class Solution {
    public int sumOfSquares(int[] nums) {
        int n=nums.length, special=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                special+=nums[i-1]*nums[i-1];
            }
        }
        return special;
    }
}