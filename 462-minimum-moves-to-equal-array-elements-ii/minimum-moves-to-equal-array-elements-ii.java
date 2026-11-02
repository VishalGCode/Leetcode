class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long sum=0; int moves=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }    
        long avg=nums[n/2];
        if(n%2==0){
            avg+=nums[n/2-1];
            avg=avg/2;
        }
        for(int i=0;i<n;i++){
            moves+=Math.abs(avg-nums[i]);
        }
        return moves;
    }
}