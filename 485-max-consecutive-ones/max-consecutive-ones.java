class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr=0, prev=0, i=0;
        while(i<nums.length){
            if(nums[i]==1) prev++;
            else{
                if(prev>=curr) curr=prev;
                prev=0;
            }i++;
        }    
        return Math.max(curr,prev);
    }
}