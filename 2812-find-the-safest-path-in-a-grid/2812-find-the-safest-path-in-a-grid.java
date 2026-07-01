
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(n - 1).get(n - 1) == 1 || grid.get(0).get(0) == 1) {
            return 0;
        }
        int[][] dist = computeDistanceGrid(grid);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] vis = new boolean[n][n];
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};
        pq.offer(new int[]{dist[0][0], 0, 0});
        vis[0][0] = true;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int ds = curr[0];
            int i = curr[1];
            int j = curr[2];
            if (i == n - 1 && j == n - 1) {
                return ds;
            }
            for (int l = 0; l < 4; l++) {
                int nrow = i + delr[l];
                int ncol = j + delc[l];
                if (isValid(nrow, ncol, n) && grid.get(nrow).get(ncol) != 1 && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    int ds1 = dist[nrow][ncol];
                    pq.offer(new int[]{Math.min(ds, ds1), nrow, ncol});
                }
            }
        }
        return 0;
    }
    private boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    private int[][] computeDistanceGrid(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] distGrid = new int[n][n];
        for (int[] row : distGrid) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    distGrid[i][j] = 0;
                }
            }
        }
        int[] delr = {-1, 1, 0, 0};
        int[] delc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + delr[i];
                int newY = y + delc[i];
                if (isValid(newX, newY, n) && distGrid[newX][newY] == Integer.MAX_VALUE) {
                    distGrid[newX][newY] = distGrid[x][y] + 1;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        return distGrid;
    }
}