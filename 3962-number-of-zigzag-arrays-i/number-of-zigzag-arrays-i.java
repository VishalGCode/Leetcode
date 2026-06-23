class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[] up = new long[m + 1];
        long[] down = new long[m + 1];
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }
        if (n == 2) {
            long ans = 0;
            for (int i = 1; i <= m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
            return (int) ans;
        }
        long[] pref = new long[m + 1];
        long[] suff = new long[m + 2];
        long[] nextUp = new long[m + 1];
        long[] nextDown = new long[m + 1];
        for (int len = 3; len <= n; len++) {
            for (int i = 1; i <= m; i++) {
                pref[i] = (pref[i - 1] + down[i]) % MOD;
            }
            for (int i = m; i >= 1; i--) {
                suff[i] = (suff[i + 1] + up[i]) % MOD;
            }
            for (int x = 1; x <= m; x++) {
                nextUp[x] = pref[x - 1];
                nextDown[x] = suff[x + 1];
            }
            long[] tmp = up;
            up = nextUp;
            nextUp = tmp;
            tmp = down;
            down = nextDown;
            nextDown = tmp;
        }
        long ans = 0;
        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }
        return (int) ans;
    }
}