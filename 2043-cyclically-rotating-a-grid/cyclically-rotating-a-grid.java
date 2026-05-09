class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length,n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int top = layer,bottom = m - layer - 1,left = layer,right = n - layer - 1;
            int[] ring = extractLayer(grid, top, bottom, left, right);
            int len = ring.length;
            int shift = k % len;
            int[] rotated = new int[len];

            // Counter-clockwise rotation
            for (int i = 0; i < len; i++) {
                rotated[(i + shift) % len] = ring[i];
            }
            fillLayer(grid, rotated, top, bottom, left, right);
        }
        return grid;
    }

    private int[] extractLayer(int[][] grid,int top,int bottom,int left,int right) {
        int perimeter = 2 * (bottom - top + right - left);
        int[] ring = new int[perimeter];
        int idx = 0;

        // left column
        for (int row = top; row <= bottom; row++) {
            ring[idx++] = grid[row][left];
        }

        // bottom row
        for (int col = left + 1; col <= right; col++) {
            ring[idx++] = grid[bottom][col];
        }

        // right column
        for (int row = bottom - 1; row >= top; row--) {
            ring[idx++] = grid[row][right];
        }

        // top row
        for (int col = right - 1; col >= left + 1; col--) {
            ring[idx++] = grid[top][col];
        }
        return ring;
    }

    private void fillLayer(int[][] grid,int[] ring,int top,int bottom,int left,int right) {
        int idx = 0;

        // left column
        for (int row = top; row <= bottom; row++) {
            grid[row][left] = ring[idx++];
        }

        // bottom row
        for (int col = left + 1; col <= right; col++) {
            grid[bottom][col] = ring[idx++];
        }

        // right column
        for (int row = bottom - 1; row >= top; row--) {
            grid[row][right] = ring[idx++];
        }

        // top row
        for (int col = right - 1; col >= left + 1; col--) {
            grid[top][col] = ring[idx++];
        }
    }
}