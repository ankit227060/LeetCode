class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long MOD = 1000000007;

        long[][] maxProd = new long[m][n];
        long[][] minProd = new long[m][n];

        maxProd[0][0] = minProd[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            maxProd[i][0] = minProd[i][0] = maxProd[i - 1][0] * grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            maxProd[0][j] = minProd[0][j] = maxProd[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];

                long a = maxProd[i-1][j] * val;
                long b = minProd[i-1][j] * val;
                long c = maxProd[i][j-1] * val;
                long d = minProd[i][j-1] * val;

                maxProd[i][j] = Math.max(Math.max(a,b), Math.max(c,d));
                minProd[i][j] = Math.min(Math.min(a,b), Math.min(c,d));
            }
        }

        long ans = maxProd[m-1][n-1];
        if(ans < 0) return -1;
        return (int)(ans % MOD);
    }
}