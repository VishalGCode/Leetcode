class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int x=nums[n-1]-nums[2];
        int y=nums[n-3]-nums[0];
        int z=nums[n-2]-nums[1];
        return Math.min(x, Math.min(y,z));
    }
}