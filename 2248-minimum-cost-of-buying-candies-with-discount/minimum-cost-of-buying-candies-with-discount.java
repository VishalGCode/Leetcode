class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int diff = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            diff += cost[i];
            if (i - 1 >= 0)
                diff += cost[i - 1];
        }
        return diff;
    }
}