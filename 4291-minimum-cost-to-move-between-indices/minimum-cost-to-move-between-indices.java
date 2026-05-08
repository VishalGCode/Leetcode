class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;

        // Prefix cost for moving left -> right
        long[] prefForward = new long[n];

        // Prefix cost for moving right -> left
        long[] prefBackward = new long[n];

        for (int i = 0; i < n - 1; i++) {
            long normalCost = nums[i + 1] - nums[i];
            boolean isClosest;

            // First index only has right neighbor
            if (i == 0) isClosest = true;
            else{
                long left = nums[i] - nums[i - 1];
                long right = nums[i + 1] - nums[i];

                // Right neighbor is closer
                isClosest = right < left;
            }
            long cost = isClosest ? 1 : normalCost;
            prefForward[i + 1] = prefForward[i] + cost;
        }

        for (int i = n - 1; i > 0; i--) {
            long normalCost = nums[i] - nums[i - 1];
            boolean isClosest;

            // Last index only has left neighbor
            if (i == n - 1) isClosest = true;
            else{
                long left = nums[i] - nums[i - 1];
                long right = nums[i + 1] - nums[i];

                // Tie goes to smaller index
                isClosest = left <= right;
            }
            long cost = isClosest ? 1 : normalCost;
            prefBackward[i - 1] = prefBackward[i] + cost;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            // Move left -> right
            if (l < r) ans[i] = (int)(prefForward[r] - prefForward[l]);

            // Move right -> left
            else ans[i] = (int)(prefBackward[r] - prefBackward[l]);
        }

        return ans;
    }
}