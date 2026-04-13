class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int diff=nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target) diff=Math.min(diff, Math.abs(i-start));
        }
        return diff; 
    }
}