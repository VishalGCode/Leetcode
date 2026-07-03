class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        long[] starts = new long[n];
        for (int i = 0; i < n; i++) {
            starts[i] = ((long) intervals[i][0] << 32) | i;
        }
        Arrays.sort(starts);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int low = 0;
            int high = n - 1;
            int ans = -1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int startVal = (int) (starts[mid] >> 32);
                if (startVal >= end) {
                    ans = (int) starts[mid];
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            result[i] = ans;
        }
        return result;
    }
}