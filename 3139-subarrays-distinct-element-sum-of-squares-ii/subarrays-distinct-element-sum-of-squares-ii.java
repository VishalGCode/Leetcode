class Solution {
    static final long MOD = 1_000_000_007L;

    class SegmentTree {
        long[] tree;
        long[] lazy;

        SegmentTree(int n) {
            tree = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void push(int node, int start, int end) {
            if (lazy[node] != 0) {
                tree[node] += (end - start + 1L) * lazy[node];

                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }

                lazy[node] = 0;
            }
        }

        void update(int node, int start, int end,
                    int l, int r, long val) {

            push(node, start, end);

            if (start > r || end < l) return;

            if (l <= start && end <= r) {
                lazy[node] += val;
                push(node, start, end);
                return;
            }

            int mid = (start + end) >> 1;

            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        long query(int node, int start, int end,
                   int l, int r) {

            push(node, start, end);

            if (start > r || end < l) return 0;

            if (l <= start && end <= r) {
                return tree[node];
            }

            int mid = (start + end) >> 1;

            return query(node * 2, start, mid, l, r)
                    + query(node * 2 + 1, mid + 1, end, l, r);
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree seg = new SegmentTree(n);

        java.util.Map<Integer, Integer> last = new java.util.HashMap<>();

        long cur = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], -1);

            int L = prev + 1;
            int R = i;

            long rangeSum = seg.query(1, 0, n - 1, L, R);
            long len = R - L + 1L;

            cur = (cur + 2L * rangeSum + len) % MOD;

            seg.update(1, 0, n - 1, L, R, 1);

            ans = (ans + cur) % MOD;

            last.put(nums[i], i);
        }

        return (int) ans;
    }
}