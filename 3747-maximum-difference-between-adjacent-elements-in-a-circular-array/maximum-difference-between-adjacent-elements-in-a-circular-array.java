class Solution {
    public int maxAdjacentDistance(int[] nums) {
    int last=Math.abs(nums[nums.length-1]-nums[0]);
    for(int i=0;i<nums.length-1;i++){
        int diff=Math.abs(nums[i]-nums[i+1]);
        last=Math.max(diff,last);
    }    
    return last;
    }
}