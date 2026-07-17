class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[] { 0, 0, 0, 0 };
        int n = obstacles.length;
        for (int pos = n - 2; pos >= 0; pos--) {
            if (obstacles[pos] != 0)
                dp[obstacles[pos]] = 1000000;
            int next = obstacles[pos + 1];
            if (next != 0)
                dp[next] = 1000000;
            for (int lane = 1; lane <= 3; lane++) {
                if (lane != next && obstacles[pos] != lane) {
                    dp[next] = Math.min(dp[next], dp[lane] + 1);
                }
            }
        }
        return dp[2];
    }
}