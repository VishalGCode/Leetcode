public class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) count++;
            zeros[i] = count;
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int required = n - i - 1,pos = i;
            while (pos < n && zeros[pos] < required) pos++;
            if (pos == n) return -1;
            while (pos > i) {
                zeros[pos] = zeros[pos - 1];
                pos--;
                swaps++;
            }
            zeros[i] = required; 
        }
        return swaps;
    }
}