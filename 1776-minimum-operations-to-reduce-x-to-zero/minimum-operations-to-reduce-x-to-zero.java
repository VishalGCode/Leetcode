class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        int target=total-x;
        if(target==0) return nums.length;
        if(target<0) return -1;
        int left=0;
        int curr=0;
        int max=-1;
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            while(curr>target && left<=i){
                curr-=nums[left];
                left++;
            }
            if(curr==target){
                max=Math.max(max,i-left+1);
            }
        }
        return max==-1?-1:nums.length-max;
    }
}