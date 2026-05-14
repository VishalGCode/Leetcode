class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;

        // Frequency array
        int[] freq = new int[n + 1];
        for (int num : nums) {
            // Number out of valid range
            if (num > n) return false;
            freq[num]++;
        }

        // Numbers 1 to n-1 must appear exactly once
        for (int i = 1; i < n; i++) if (freq[i] != 1) return false;

        // Number n must appear exactly twice
        return freq[n] == 2;
    }
}