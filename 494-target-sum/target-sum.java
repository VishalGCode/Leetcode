
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Target cannot be reached if it exceeds the total sum.
        if (Math.abs(target) > sum) {
            return 0;
        }

        // Transform Target Sum into a subset-sum problem.
        if ((sum + target) % 2 != 0) {
            return 0;
        }

        int subsetSum = (sum + target) / 2;

        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }
}
