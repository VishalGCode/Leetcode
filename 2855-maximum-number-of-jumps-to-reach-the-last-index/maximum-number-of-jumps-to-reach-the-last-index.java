class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        // dp[i] = maximum jumps needed to reach index i
        int[] dp = new int[n];

        // Fill with -1 means unreachable
        Arrays.fill(dp, -1);

        // Starting index needs 0 jumps
        dp[0] = 0;

        // Try jumping from every index i
        for (int i = 0; i < n; i++) {

            // If current index cannot be reached, skip it
            if (dp[i] == -1) {
                continue;
            }

            // Try jumping to every next index j
            for (int j = i + 1; j < n; j++) {

                // Check jump condition
                if (Math.abs(nums[j] - nums[i]) <= target) {

                    // Update maximum jumps for index j
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        // Return answer for last index
        return dp[n - 1];
    }
}