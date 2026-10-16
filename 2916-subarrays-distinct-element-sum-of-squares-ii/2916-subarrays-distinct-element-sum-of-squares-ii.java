class Solution {
    long[] t, lz;

    void push(int x, int l, int r) {
        if (lz[x] != 0) {
            int m = (l + r) / 2;
            t[2 * x] += lz[x] * (m - l + 1);
            lz[2 * x] += lz[x];
            t[2 * x + 1] += lz[x] * (r - m);
            lz[2 * x + 1] += lz[x];
            lz[x] = 0;
        }
    }

    void upd(int x, int l, int r, int a, int b) {
        if (b < l || r < a) return;
        if (a <= l && r <= b) {
            t[x] += r - l + 1;
            lz[x]++;
            return;
        }
        push(x, l, r);
        int m = (l + r) / 2;
        upd(2 * x, l, m, a, b);
        upd(2 * x + 1, m + 1, r, a, b);
        t[x] = t[2 * x] + t[2 * x + 1];
    }

    long qry(int x, int l, int r, int a, int b) {
        if (b < l || r < a) return 0;
        if (a <= l && r <= b) return t[x];
        push(x, l, r);
        int m = (l + r) / 2;
        return qry(2 * x, l, m, a, b) + qry(2 * x + 1, m + 1, r, a, b);
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long mod = 1000000007L, sq = 0, ans = 0;
        t = new long[4 * n];
        lz = new long[4 * n];
        int[] last = new int[100001];
        Arrays.fill(last, -1);
        for (int j = 0; j < n; j++) {
            int p = last[nums[j]];
            long s = qry(1, 0, n - 1, p + 1, j);
            sq = (sq + 2 * (s % mod) + (j - p)) % mod;
            upd(1, 0, n - 1, p + 1, j);
            ans = (ans + sq) % mod;
            last[nums[j]] = j;
        }
        return (int) ans;
    }
}