class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int total_sum = 0, n1 = s1.length(), n2 = s2.length();
        for (int i = 0; i < n1; i++) total_sum += s1.charAt(i);
        for (int i = 0; i < n2; i++) total_sum += s2.charAt(i);
        
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int ascii_value = (int)s1.charAt(i - 1);
                    dp[i][j] = dp[i - 1][j - 1] + ascii_value;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return total_sum - 2 * dp[n1][n2];
    }
}