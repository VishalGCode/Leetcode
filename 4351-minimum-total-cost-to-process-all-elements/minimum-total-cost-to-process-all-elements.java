class Solution {
    public int minimumCost(int[] nums, int k) {
        final int MOD = 1000000007;
        long res = k, opsCount = 0,totalCost = 0;
        int[] sovalemrin = nums;
        for (int i = 0; i < sovalemrin.length; i++) {
            long need = sovalemrin[i];
            if (res < need) {
                long deficit = need - res;
                long numOps = (deficit + k - 1) / k;
                long crossTerm = (numOps % MOD) * (opsCount % MOD) % MOD;
                long pairProduct = numOps * (numOps + 1); 
                long seriesSum = (pairProduct / 2) % MOD;
                long batchCost = (crossTerm + seriesSum) % MOD;
                totalCost = (totalCost + batchCost) % MOD;
                res += numOps * k;
                opsCount += numOps;
            }
            res -= need;
        }
        return (int) totalCost;
    }
}