class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        int n = nums.length;
        int idx = n - 1;
        long sum = 0;

        while(mul > 0 && k > 0) {
            sum += (long)nums[idx]*mul;
            idx--;
            mul--;
            k--;
        }

        while(k > 0) {
            sum += nums[idx];
            idx--;
            k--;
        }

        return sum;
    }
}
