class Solution {
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int dis[][] = new int[m][n];
        for(int row[] : dis) Arrays.fill(row, Integer.MAX_VALUE);
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});
        dis[0][0] = grid.get(0).get(0);

        while(!dq.isEmpty()) {
            int curr[] = dq.pollFirst();
            int cx = curr[0], cy = curr[1];
            if(cx == m - 1 && cy == n - 1) return true;

            for(int d[] : dir) {
                int nx = cx + d[0], ny = cy + d[1];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                int cost = dis[cx][cy] + grid.get(nx).get(ny);
                if(cost >= health) continue;
                if(cost < dis[nx][ny]) {
                    dis[nx][ny] = cost;
                    if(grid.get(nx).get(ny) == 0) dq.offerFirst(new int[]{nx, ny});
                    else dq.offerLast(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}