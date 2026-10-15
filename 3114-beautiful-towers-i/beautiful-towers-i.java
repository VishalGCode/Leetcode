class Solution {
    public long maximumSumOfHeights(int[] maxHeights) {
        int n = maxHeights.length;
        long maxSum = 0;
        for(int i=0;i<n;i++){
            long curr = maxHeights[i];
            long left = maxHeights[i];
            for (int j=i-1;j>=0;j--){
                left = Math.min(left, maxHeights[j]);
                curr += left;
            }
            long right = maxHeights[i];
            for(int j=i+1;j<n;j++){
                right = Math.min(right, maxHeights[j]);
                curr += right;
            }
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }
}
