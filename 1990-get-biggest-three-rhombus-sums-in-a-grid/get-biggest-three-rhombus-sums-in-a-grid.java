class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> top = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                top.add(grid[i][j]);
                for (int r = 1; i - r >= 0 && i + r < m && j - r >= 0 && j + r < n; r++) {
                    int sum = 0;
                    for (int t = 0; t <= r; t++) sum += grid[i - r + t][j + t];
                    for (int t = 1; t <= r; t++) sum += grid[i + t][j + r - t];
                    for (int t = 1; t <= r; t++) sum += grid[i + r - t][j - t];
                    for (int t = 1; t < r; t++) sum += grid[i - t][j - r + t];
                    top.add(sum);
                    if (top.size() > 50) while (top.size() > 10) top.pollLast();
                }
            }
        }
        int k = Math.min(3, top.size());
        int[] ans = new int[k];
        int idx = 0;
        for (int val : top) {
            if (idx == k) break;
            ans[idx++] = val;
        }
        return ans;
    }
}
