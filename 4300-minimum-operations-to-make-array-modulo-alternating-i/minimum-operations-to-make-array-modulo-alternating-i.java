class Solution {
    public int minOperations(int[] nums, int k) {
        int[] even = new int[k], odd = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int r = nums[i] % k;
            if ((i & 1) == 0) even[r]++;
            else odd[r]++;
        }
        int[] costEven = new int[k];
        int[] costOdd = new int[k];
        for (int target = 0; target < k; target++) {
            int eCost = 0;
            int oCost = 0;
            for (int r = 0; r < k; r++) {
                int dist =Math.min((target - r + k) % k,(r - target + k) % k);
                eCost += even[r] * dist;
                oCost += odd[r] * dist;
            }
            costEven[target] = eCost;
            costOdd[target] = oCost;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i == j) continue;
                ans = Math.min(ans,costEven[i] + costOdd[j]);
            }
        }
        return ans;
    }
}