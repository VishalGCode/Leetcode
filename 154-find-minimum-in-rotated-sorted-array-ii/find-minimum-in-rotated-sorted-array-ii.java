class Solution{
    public int findMin(int[] nums){
        int n=nums.length-1;
        int last=nums[n];
        int left=0, right=n;
        while(left<right){
            int mid = (left+right) >> 1;
            if(nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right--;
        }
        return nums[left];
    }
}