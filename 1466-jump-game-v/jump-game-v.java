class Solution {
    int[] dp;
    int n;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        dp = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d));
        }
        return ans;
    }

    // DFS function to calculate maximum jumps from index i
    private int dfs(int i, int[] arr, int d) {
        if (dp[i] != 0) return dp[i];

        // Minimum jump count is 1
        int best = 1;
        int[] dir = {-1, 1};
        for (int move : dir) {
            for (int step = 1; step <= d; step++) {
                int nxt = i + move * step;

                // Stop if out of bounds
                if (nxt < 0 || nxt >= n) break;

                // Cannot jump to equal or taller element
                // Also blocks further movement in this direction
                if (arr[nxt] >= arr[i]) break;

                // Recursively calculate best path
                best = Math.max(best,1 + dfs(nxt, arr, d));
            }
        }
        return dp[i] = best;
    }
}