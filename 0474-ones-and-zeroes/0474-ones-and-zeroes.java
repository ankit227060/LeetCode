class Solution {
    private int[] getCnts(String s) {
        int zeros = 0;
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') zeros++;
            else ones++;
        }
        return new int[] {zeros , ones};
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int[] cost = getCnts(s);
            int cst0 = cost[0];
            int cst1 = cost[1];

            for (int i = m; i >= cst0; i--) {
                for (int j = n; j >= cst1; j--) {
                    dp[i][j] = Math.max(dp[i][j] , 1 + dp[i - cst0][j - cst1]);
                }
            }
        }
        return dp[m][n];
    }
}