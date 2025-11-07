class Solution {
    public int numDistinct(String s, String t) {
         
        return bottom(s, t);
    }
    int rec(String s, String t, int n, int m) {
        if (m < 0)
            return 1;
        if (n < 0)
            return 0;

        int inc = 0;
        if (s.charAt(n) == t.charAt(m)) {
            inc = rec(s, t, n - 1, m - 1);
        }
        int exc = rec(s, t, n - 1, m);
        return inc + exc;
    }
    int top(String s, String t, int n, int m, int[][] dp) {
        if (m < 0)
            return 1;
        if (n < 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        int inc = 0;
        if (s.charAt(n) == t.charAt(m)) {
            inc = top(s, t, n - 1, m - 1, dp);
        }
        int exc = top(s, t, n - 1, m, dp);
        return dp[n][m] = inc + exc;
    }
    int bottom(String s, String t) {
        int r = s.length();
        int c = t.length();

        int[][] dp = new int[r + 1][c + 1];
        for (int i = 0; i <= r; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int inc = 0;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    inc = dp[i-1][j-1];
                }
                int exc = dp[i-1][j];
                dp[i][j] = inc + exc;
            }
        }
        return dp[r][c];
    }
}