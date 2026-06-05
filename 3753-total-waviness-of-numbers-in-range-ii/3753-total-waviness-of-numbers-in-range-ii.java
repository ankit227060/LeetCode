class Solution {
    private String s;
    private Map<String, long[]> mp = new HashMap<>();
    private long[] dfs(int i, int a, int b, int t, int st, int len) {
        if (i == s.length()) return new long[]{1, 0};
        String key = i + "," + a + "," + b + "," + t + "," + st + "," + len;
        if (mp.containsKey(key)) return mp.get(key);
        long cnt = 0, wav = 0;
        int limit = t == 1 ? (s.charAt(i) - '0') : 9;
        for (int d = 0; d <= limit; d++) {
            long[] res = dfs(i + 1, b, d,
                t == 1 && d == (s.charAt(i) - '0') ? 1 : 0,
                (st == 1 || d > 0) ? 1 : 0,
                (st == 1 || d > 0) ? len + 1 : 0);
            long c = res[0], w = res[1];
            if (len > 1 && ((a < b && b > d) || (a > b && b < d))) w += c;
            cnt += c;
            wav += w;
        }
        long[] ans = {cnt, wav};
        mp.put(key, ans);
        return ans;
    }
    private long solve(long n) {
        s = Long.toString(n);
        mp.clear();
        return dfs(0, 0, 0, 1, 0, 0)[1];
    }
    public long totalWaviness(long l, long r) {
        return solve(r) - solve(l - 1);
    }
}