class Solution {
    int res = 0;
    public int countArrangement(int n) {
        if (n == 0) return 0;
        backtrack(1, n, new int[n+1]);
        return res;
    }

    private void backtrack(int pos, int n, int[] usedArr) {
        if (pos > n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (usedArr[i] == 0 && (pos % i == 0 || i % pos == 0)) {
                usedArr[i] = 1;
                backtrack(pos+1, n, usedArr);
                usedArr[i] = 0;
            }
        }
    }
}