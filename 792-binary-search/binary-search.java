class Solution {
    public int search(int[] nums, int target) {
    int l=0,r=nums.length-1;
    if((r-l+1)==0) return -1; //used when the array is short
    while(l<r){
        int mid=l+(r-l+1)/2;
        if(target< nums[mid]) r=mid-1;
        else l=mid;
    }
    return nums[l]==target?l:-1;
    }
}