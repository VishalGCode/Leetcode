class Solution {
    public boolean canJump(int[] nums) {

        // farthest = maximum index we can reach so far
        int far = 0;

        // Traverse array
        for (int i = 0; i < nums.length; i++) {

            // If current index is unreachable
            // then we cannot move further
            if (i > far) {
                return false;
            }

            // Update farthest reachable index
            far = Math.max(far,i + nums[i]);

            // If we can already reach last index , return early
            if (far >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}