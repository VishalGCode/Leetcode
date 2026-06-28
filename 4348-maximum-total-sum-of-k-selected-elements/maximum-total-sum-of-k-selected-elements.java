class Solution {
    public long maxSum(int[] nums, int k, int mul) {
    Arrays.sort(nums);
    long ans = 0;
    int i = nums.length-1;
    while(k>0){
        if(mul > 0) ans += (long)nums[i]*mul;
        else ans += (long)nums[i];
        i--;
        k--;
        mul--;
    }    
    return ans;
    }
}