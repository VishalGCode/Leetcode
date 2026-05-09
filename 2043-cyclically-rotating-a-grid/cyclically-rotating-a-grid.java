class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            // boundaries
            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            // extract layer elements
            java.util.List<Integer> vals = new java.util.ArrayList<>();

            // top row
            for (int j = left; j <= right; j++) vals.add(grid[top][j]);

            // right column
            for (int i = top + 1; i <= bottom - 1; i++) vals.add(grid[i][right]);

            // bottom row
            for (int j = right; j >= left; j--) vals.add(grid[bottom][j]);

            // left column
            for (int i = bottom - 1; i >= top + 1; i--) vals.add(grid[i][left]);

            int len = vals.size();
            int rot = k % len;

            // rotate counter-clockwise
            java.util.List<Integer> rotated = new java.util.ArrayList<>(len);
            for (int i = 0; i < len; i++) rotated.add(vals.get((i + rot) % len));

            int idx = 0;

            // put back top row
            for (int j = left; j <= right; j++) grid[top][j] = rotated.get(idx++);

            // put back right column
            for (int i = top + 1; i <= bottom - 1; i++) grid[i][right] = rotated.get(idx++);

            // put back bottom row
            for (int j = right; j >= left; j--) grid[bottom][j] = rotated.get(idx++);

            // put back left column
            for (int i = bottom - 1; i >= top + 1; i--) grid[i][left] = rotated.get(idx++);
        }
        return grid;
    }
}