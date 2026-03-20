class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int rows = m - k + 1, cols = n - k + 1;

        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                List<Integer> vals = new ArrayList<>();

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        vals.add(grid[x][y]);
                    }
                }

                Collections.sort(vals);

                int best = Integer.MAX_VALUE;
                for (int t = 1; t < vals.size(); t++) {
                    if (!vals.get(t).equals(vals.get(t - 1))) {
                        best = Math.min(best, vals.get(t) - vals.get(t - 1));
                    }
                }

                ans[i][j] = (best == Integer.MAX_VALUE) ? 0 : best;
            }
        }

        return ans;
    }
}