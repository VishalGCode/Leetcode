class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length, count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.clear();
            for (int j = i; j < n; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
                if (freq.getOrDefault(target, 0) > (j - i + 1) / 2) {
                    count++;
                }
            }
        }
        return count;
    }
}