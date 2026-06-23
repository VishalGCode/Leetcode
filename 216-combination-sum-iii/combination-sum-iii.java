class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int start, int k, int target, List<Integer> curr, List<List<Integer>> ans) {
        int remaining = k - curr.size();
        if (remaining == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if (target < 0) return;
        int minSum = 0;
        for (int x = start; x < start + remaining; x++) {
            if (x > 9) return;
            minSum += x;
        }
        int maxSum = 0;
        for (int x = 9; x > 9 - remaining; x--) {
            maxSum += x;
        }
        if (target < minSum || target > maxSum) return;
        for (int num = start; num <= 9; num++) {
            if (num > target) break;
            curr.add(num);
            backtrack(num + 1, k, target - num, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}