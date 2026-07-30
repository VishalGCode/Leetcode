class Solution {
    public int diagonalPrime(int[][] nums) {
        int max = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((i==j || i+j==n-1) && isPrime(nums[i][j])){
                    max = Math.max(max, nums[i][j]);
                }
            }
        }
        return max;
    }
    public boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2; i*i<=num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}