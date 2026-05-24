class Solution {
    public int minimumSwaps(int[] nums) {
        int l = 0, swap = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == 0 && nums[r] != 0) {
                swap++;
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            } else if (nums[r] == 0)
                r--;
            else
                l++;
        }
        return swap;
    }
}