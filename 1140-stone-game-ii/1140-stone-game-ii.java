class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n + 1];        
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        Integer[][] memo = new Integer[n][n + 1];
                return dfs(0, 1, piles, suffixSum, memo);
    }
        private int dfs(int i, int M, int[] piles, int[] suffixSum, Integer[][] memo) {
        int n = piles.length;
        if (i >= n) return 0;
            if (2 * M >= n - i) {
            return suffixSum[i];
        }
                if (memo[i][M] != null) return memo[i][M];
        
        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int opponent = dfs(i + X, Math.max(M, X), piles, suffixSum, memo);
            best = Math.max(best, suffixSum[i] - opponent);
        }
                memo[i][M] = best;
        return best;
    }
}